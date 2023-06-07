package snake_ladder_lld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderBoard
{
     int size;
     public List<Snake> snakelist;
     public List<Ladder> ladderlist;

     public Map<String,Integer> playerpieces;

     public SnakeLadderBoard(int size)
     {
          this.size = size;
          this.snakelist = new ArrayList<Snake>();
          this.ladderlist = new ArrayList<Ladder>();
          this.playerpieces = new HashMap<String , Integer>();
     }

     public int getSize() {
          return size;
     }

     public void setSize(int size) {
          this.size = size;
     }

     public List<Snake> getSnakelist() {
          return snakelist;
     }

     public void setSnakelist(List<Snake> snakelist) {
          this.snakelist = snakelist;
     }

     public List<Ladder> getLadderlist() {
          return ladderlist;
     }

     public void setLadderlist(List<Ladder> ladderlist) {
          this.ladderlist = ladderlist;
     }

     public Map<String, Integer> getPlayerpieces() {
          return playerpieces;
     }

     public void setPlayerpieces(Map<String, Integer> playerpieces) {
          this.playerpieces = playerpieces;
     }
}
