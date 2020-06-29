#According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
#Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
#Any live cell with fewer than two live neighbors dies, as if caused by under-population.
#Any live cell with two or three live neighbors lives on to the next generation.
#Any live cell with more than three live neighbors dies, as if by over-population..
#Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
#Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
#The commented code T: O(N*M) S: O(N*M)
#The non-commedted code: T:O(N*M) S:O(1)
#Link: https://leetcode.com/problems/game-of-life/

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
        
        
        

        
    
        
        
