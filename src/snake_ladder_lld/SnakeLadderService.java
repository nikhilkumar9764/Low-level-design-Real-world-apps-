package snake_ladder_lld;

import java.util.*;

public class SnakeLadderService 
{
    
  private SnakeLadderBoard snakeLadderBoard;
  private int initialNumPlayers;
  private boolean isCompleted;
  private Queue<Player> players;
  private int no_dices;

  private boolean shouldGameContinueTillLast, shouldAllowMultipleDiceRolls;
  private static final int DEFAULT_BOARD_SIZE = 100;
  private static final int DEFAULT_NO_OF_DICE = 1;

  public void setNo_dices(int no_dices) {
    this.no_dices = no_dices;
  }

  public void setShouldGameContinueTillLast(boolean shouldGameContinueTillLast) {
    this.shouldGameContinueTillLast = shouldGameContinueTillLast;
  }

  public void setShouldAllowMultipleDiceRolls(boolean shouldAllowMultipleDiceRolls) {
    this.shouldAllowMultipleDiceRolls = shouldAllowMultipleDiceRolls;
  }

  public SnakeLadderService(int sz) {
    this.snakeLadderBoard = new SnakeLadderBoard(sz);
    this.players = new LinkedList<Player>();
    this.no_dices = SnakeLadderService.DEFAULT_NO_OF_DICE;
  }

  public SnakeLadderService()
  {
      this(SnakeLadderService.DEFAULT_BOARD_SIZE);
  }


  /**  ==== INITIALIZE BOARD === **/
  public void setPlayers(List<Player> plist)
  {
      this.players = new LinkedList<Player>();
      Map<String, Integer> playerpos = new HashMap<String , Integer>();
      for(Player p : plist)
      {
          this.players.add(p);
          playerpos.put(p.getName(),0);
      }
      snakeLadderBoard.setPlayerpieces(playerpos);
  }

  public void setSnakelist(List<Snake> snakelist)
  {
      snakeLadderBoard.setSnakelist(snakelist);
  }

  public void setLadderlist(List<Ladder> ladderlist)
  {
      snakeLadderBoard.setLadderlist(ladderlist);
  }

  /** Core business logic for game **/

  private int getpositionAfterSnakesLadders(int newpos)
  {
      int prev_pos;

      do{
          prev_pos = newpos;
          for(Snake s: snakeLadderBoard.getSnakelist())
          {
              if(s.getStart() == newpos)
              {
                  newpos = s.getEnd();
              }
          }

          for(Ladder l: snakeLadderBoard.getLadderlist())
          {
              if(l.getStart() == newpos)
              {
                  newpos = l.getEnd();
              }
          }
      }while(prev_pos!=newpos);

      return newpos;
  }

  private void movePlayer(Player p , int moves)
  {
      int oldpos = snakeLadderBoard.getPlayerpieces().get(p.getName());
      int curr_pos = oldpos + moves;

      if(curr_pos > snakeLadderBoard.getSize())
      {
          curr_pos = oldpos;
      }
      else{
          curr_pos = getpositionAfterSnakesLadders(curr_pos);
      }
      snakeLadderBoard.getPlayerpieces().put(p.getName() , curr_pos);
      System.out.println("Player" + p.getName() + "rolled a"+ moves +"and moved from"+ oldpos +"to "+curr_pos);
  }

  private int getRollDice()
  {
      return DiceService.roll();
  }

  private boolean hasWon(Player p)
  {
       int player_pos = snakeLadderBoard.getPlayerpieces().get(p.getName());
       int winning_pos = snakeLadderBoard.getSize();

       return player_pos == winning_pos;
  }

  private boolean hasGameCompleted()
  {
      int org = players.size();
      return org < initialNumPlayers;
  }

  public void startGame()
  {
      while(!hasGameCompleted())
      {
          int dice_val = getRollDice();
          Player curr_player= players.poll();
          movePlayer(curr_player,dice_val);
          if(hasWon(curr_player))
          {
              System.out.println("Player " + curr_player + " played "+ dice_val +" and won");
              snakeLadderBoard.getPlayerpieces().remove(curr_player.getId());
          }
          else{
              players.add(curr_player);
          }
      }
  }


}
