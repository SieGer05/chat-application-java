
# Java Client-Server Communication Project

This Java project demonstrates a simple client-server communication system using sockets. It consists of a server application and a client application that allow text-based communication between them. Below are detailed instructions on how to compile and run the server and client components.

## Table of Contents

- [Server](#server)
- [Client](#client)
- [Compiling](#compiling)
- [Running the Server](#running-the-server)
- [Running the Client](#running-the-client)

### Server

The server is responsible for listening for incoming client connections and handling the communication.

###Client

The client connects to the server and allows you to send and receive messages

### Compiling

Compile the server code using the following command:

```bash
javac Server.java
javac Client.java
```

or

```bash
javac *.java
```

### Running The Server
Start the server with the following command:

```bash
start java Server
```

### Running the Client
Start the client with the following command:

```bash
java Client
```

If you are running the server and client on the same machine, when prompted to enter an IP address in the client program, you can simply enter "N", and the program will recognize that it is running locally. However, if the client and server are on different machines, please enter the IP address of the server. You can obtain the server's IP address by running ipconfig on Windows or ifconfig on Linux.

Note: It's important to start the server first before running the client.

## Notes

- The server uses port 2005 by default. You can change the port by providing it as a command line argument when running the server (e.g., `java Server 3000`).

- The client uses "localhost" as the default hostname. You can specify a different hostname as a command line argument (e.g., `java Client example.com`).

- To end the conversation, enter "fin" as a message in either the server or client application.

## Customization

Feel free to customize and extend this project to meet your specific needs. Explore the possibilities of client-server communication in Java and adapt the code as required. Enjoy exploring the world of networking and communication!



