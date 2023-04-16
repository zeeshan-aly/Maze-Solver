/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maze_solver;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JFrame;

/**
 *
 * @author Syed Mohd Zeeshan
 */
public class Maze_Solver extends JFrame {

     private int[][] maze = 
            
                
                {{1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,1,0,1,0,1,1,1,1,1,0,1},
		{1,0,1,0,1,0,1,0,0,0,0,0,1},
		{1,0,1,1,1,1,1,0,1,1,1,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,0,0,1,0,1,0,0,0,1},
		{1,1,1,1,1,0,1,1,1,1,1,0,1},
		{1,0,0,0,1,0,0,0,0,0,0,9,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1}};
     
      public  List<Integer> path = new ArrayList<>();
      
      public Maze_Solver(){
          setTitle("MAZE SOLVER");
          setSize(640,720);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          dfs.searchPath(maze, 1, 1, path);
          //System.out.println(path);
      }
      
      @Override
      public void paint(Graphics g){
          g.translate(50, 50);
          for(int i =0;i<maze.length;i++){
              for(int j =0;j<maze[0].length;j++){
                  Color color;
                  switch(maze[i][j]){
                      case 1: color=Color.BLACK;break;
                      case 9: color = Color.RED;break;
                      default: color = Color.WHITE;break;
                  }
                  g.setColor(color);
                  g.fillRect(30*j,30*i,30,30);
                  g.setColor(Color.RED);
                  g.drawRect(30*j,30*i,30,30);
              }
          }
          for(int i =0;i<path.size();i+=2){
              int pathx= path.get(i);
              int pathy = path.get(i+1);
              System.out.println("X "+pathx);
              System.out.println("Y "+pathy);
              g.setColor(Color.GREEN);
              g.fillRect(30*pathx,30*pathy,20,30);
          }
      }
      
      public static void main(String[] args){
          Maze_Solver view = new Maze_Solver();
          view.setVisible(true);
      }


}
