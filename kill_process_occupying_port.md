gives the process id of the port 

SAMPLE : lsof -i tcp:<PORT NUMBER>
ACTUAL : lsof -i tcp:4004

process id = 12345

SAMPLE : kill -9 <process id>
ACTUAL : kill -9 12345 
