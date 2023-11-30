# blockchain
This repository contains a simple Java implementation of a blockchain. A blockchain is a distributed ledger that records transactions in a secure and transparent way. This implementation demonstrates the basic concepts of blockchain technology, including blocks, hashes, and the chain of blocks.

Features:

* Simple and easy-to-understand code
* Demonstrates the basic concepts of blockchain technology


Requirements:

* Java Development Kit (JDK) 11 or higher

Installation:

1. Clone this repository:
git clone https://github.com/your-username/simple-java-blockchain.git

2. Open the project in your favorite IDE.

3. Run the main class:

Blockchain blockchain = new Blockchain();
Scanner scanner = new Scanner(System.in);

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
