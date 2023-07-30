# -*- coding: utf-8 -*-
import socket
from threading import Thread
# if the server is not on this machine,
# put the private (network) IP address (e.g 192.168.1.2)
host = "localhost"
port =  8080# server's port
# initialize TCP socket
connector_sockect = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print("Connecting to " +str(host) + ": " +str(port)+"...")
# connect to the server
connector_sockect.connect((host,port))
print("[+] Connected.")
# prompt the client for a name
print("Enter your name :")
name = input()
def messages():
    while True:
        message = connector_sockect.recv(1024).decode()
        print("\t \n" + message)
thread = Thread(target=messages) # make a thread that listens for messages to this client
thread.daemon = True # make the thread daemon so it ends whenever the main thread ends
thread.start()
print("Start sending messages, enter x to stop sending")
while True:
    message = input() # input message we want to send to the server
    
    if message == 'x': # exit program if x is typed
        break
    message =str(name) + " : " + str(message)
    connector_sockect.send(message.encode()) #send the message
    
# close the socket
connector_sockect.close()
