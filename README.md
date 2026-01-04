🎯 RMI Calculator Project 🎯
📝 Description
This project implements a simple remote calculator using Java RMI (Remote Method Invocation).

The server provides basic arithmetic operations (add, subtract, multiply, divide) for any number of inputs.

The client allows the user to choose the operation, input multiple numbers, and get the result from the remote server.

Supports dynamic number of inputs and handles division by zero.

Project Structure
RMI-Calculator/ │ ├─ MathRemote.java // RMI interface ├─ MathProvider.java // RMI server implementation ├─ MathClient.java // RMI client └─ README.md // Project instructions

How It Works
Server (MathProvider)

Implements the MathRemote interface.

Starts the RMI registry on port 1099.

Binds the server object with the name "MATH-SERVER".

Client (MathClient)

Looks up the server object using "rmi://localhost/MATH-SERVER".

Prompts the user for an arithmetic operation and numbers.

Sends the request to the server and prints the result.

How to Run
Step 1: Compile all Java files
Open a terminal in the project folder and run:

javac *.java

This will generate .class files for all Java files.

Step 2: Start the Server
Run the server in a terminal:

java MathProvider

You should see:

Math Server running...

Step 3: Run the Client
Open another terminal in the same folder and run:

java MathClient
