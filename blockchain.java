import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blockchain {

    private List<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
    }

    public void addBlock(Block block) {
        if (isValidBlock(block)) {
            chain.add(block);
        } else {
            System.out.println("Invalid block: " + block);
        }
    }

    private boolean isValidBlock(Block block) {
        if (block.getPreviousHash() == null) {
            return true;
        } else {
            return block.getPreviousHash().equals(getLatestBlock().getHash());
        }
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void printChain() {
        for (Block block : chain) {
            System.out.println(block);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Blockchain blockchain = new Blockchain();

        System.out.println("Enter data to add to the blockchain:");
        String data = scanner.nextLine();

        Block genesisBlock = new Block("Genesis Block", null, data);
        blockchain.addBlock(genesisBlock);

        while (true) {
            System.out.println("Enter more data to add to the blockchain:");
            data = scanner.nextLine();

            Block newBlock = new Block("", blockchain.getLatestBlock().getHash(), data);
            blockchain.addBlock(newBlock);

            System.out.println("Blockchain:");
            blockchain.printChain();
        }
    }
}

class Block {

    private String previousHash;
    private String hash;
    private String data;

    public Block(String previousHash, String hash, String data) {
        this.previousHash = previousHash;
        this.hash = hash;
        this.data = data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Block{" +
                "previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
