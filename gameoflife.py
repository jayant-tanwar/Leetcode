
class Solution:
    def gameOfLife(self, board):
        
        #b=[[float('inf')]*(len(board[0])) for _ in range(0,len(board))]
        
        X=[-1,1,0,0,-1,1,1,-1]
        Y=[0,0,1,-1,-1,-1,1,1]
        
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                c=0
                for k in range(0,len(X)):
                    x,y=X[k],Y[k]
                    x=x+i
                    y=y+j
                    if(x>=0 and x<len(board) and y<len(board[0]) and y>=0):
                        if(board[x][y]==1 or board[x][y]==-1):
                            c+=1

                if(board[i][j]==1):
                    if(c<2):
                        #death by under population
                        board[i][j]=-1
                    elif(2<=c and c<=3):
                        #stays the same
                        board[i][j]=1
                    elif(c>3):
                        #deaath by over population
                        board[i][j]=-1
                else:
                    if(c==3):
                        #rebirth
                        board[i][j]=2
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                if(board[i][j]==-1):
                    board[i][j]=0
                elif(board[i][j]==2):
                    board[i][j]=1
                    
                        
        
#         for i in range(0,len(board)):
#             for j in range(0,len(board[0])):
#                 c=0
#                 for k in range(0,len(X)):
#                     x,y=X[k],Y[k]
#                     x=x+i
#                     y=y+j
#                     if(x>=0 and x<len(b) and y<len(b[0]) and y>=0):
#                         if(board[x][y]==1):
#                             c+=1
#                 if(board[i][j]==1):
#                     if(c<2):
#                         #death by under population
#                         b[i][j]=0
#                     elif(2<=c and c<=3):
#                         #stays the same lives on to the next generation
#                         b[i][j]=1
#                     elif(c>3):
#                         #death by over population
#                         b[i][j]=0
#                 else:
#                     if(c==3):
#                         #rebirth
#                         b[i][j]=1
#                     else:
#                         b[i][j]=0
        
#         for i in range(0,len(board)):
#             for j in range(0,len(board[0])):
#                 board[i][j]=b[i][j]
        
        
        

        
    
        
        
