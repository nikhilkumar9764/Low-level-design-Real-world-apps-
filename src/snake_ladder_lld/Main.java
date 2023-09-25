package snake_ladder_lld;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);

         int sz = s.nextInt();

         int no_snakes = s.nextInt();
         List<Snake> snakeList = new ArrayList<Snake>();
         for(int j=0;j<no_snakes;j++)
         {
             int start_pos = s.nextInt();
             int end_pos = s.nextInt();
             snakeList.add(new Snake(start_pos,end_pos));
         }

        int no_ladders = s.nextInt();
        List<Ladder> ladderList = new ArrayList<Ladder>();
        for(int j=0;j<no_ladders;j++)
        {
            int start_pos = s.nextInt();
            int end_pos = s.nextInt();
            ladderList.add(new Ladder(start_pos,end_pos));
        }

        int no_player = s.nextInt();
        List<Player> plist = new ArrayList<>();
        for(int j=0;j<no_player;j++)
        {
            String name = s.next();
            plist.add(new Player(name,j+1));
        }
        SnakeLadderService slService = new SnakeLadderService(sz);
        slService.setSnakelist(snakeList);
        slService.setLadderlist(ladderList);
        slService.setPlayers(plist);

        slService.startGame();
    }
}
