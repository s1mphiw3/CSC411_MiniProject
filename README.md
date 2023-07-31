# CSC411_MiniProject
# Consumer Producer Problem
Producer and Consumer problem making use of a shared buffer. In which no client can read from an empty buffer and no producer can write to a full buffer. We made use of the Java programming Language.
We have a student class, which is then used by the producer to generate random students saving their data onto xml files. 
Then the courses class which is used in the student class to assign mark to specific courses.
We also have the producer and consumer classes respectively. The producer is responsible for genarating the list of students to be used by the the consumer. The consumer cannot make use of unnavailable students files, and producer can not produce the students list to exceed the allocated buffer size. 

# Socket Programming
Here we made use of socket progamming to develop a messaging interface between clients 

host = ”localhost” 
port = 8080

server.py
It establishes a region of shared memory between the clients, to enable the exchange of information or communication between these clients 
client.py
Clients connect to server using TCP/IP Protocol, each sends and receives messages from the other through the server
Operation of the Client and server App
1.	Firstly, run the server on server.py 
2.	For each client then run client.py, connected clients will be shown on the server and will be able to communicate with each other
3.	Each client is required to enter his/her name before being prompted/allowed to send or receive a message
4.	Upon sending the message, the message sent is displayed on the client screen first, on the server and to the receiver showing the name of the sender and message being sent
5.	If a connected client type ‘x’ it is disconnected from the server 

