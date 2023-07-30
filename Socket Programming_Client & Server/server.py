# -*- coding: utf-8 -*-

import socket
from threading import Thread

host = "localhost"
port = 8080 # port we want to use
client_sockets = set() # create list of connected clients
connector_sockect = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # create a TCP socket
connector_sockect.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1) # ensure port can be re-used
connector_sockect.bind((socket.gethostname(), port))# bind socket to address
connector_sockect.listen()# listen for upcoming connections
print( "Waiting for clients...")
def clients(client):
    while True:
        try:
            msg = client.recv(1024).decode() #listen for messages from client
        except Exception as e:
                client_sockets.remove(client) #remove clients that are no longer connected
        else: #print mmessage that we receive
            print(str(msg))
        
        for client_socket in client_sockets: # go through all connected sockets and send message
            client_socket.send(msg.encode())  
    
while True:
    c_socket,c_address = connector_sockect.accept()
    print(str(c_address) + "connected")
    client_sockets.add(c_socket) #add new client to the list of sockets
    thread = Thread(target=clients,args=(c_socket,)) #start a new thread that listens for each clients message
    thread.daemon = True  #make a thread daemon so it ends when main thread ends
    thread.start() #start thread
    
#close client sockets
for client in client_sockets:
    client.close()
 #close server socket
connector_sockect.close()
    
