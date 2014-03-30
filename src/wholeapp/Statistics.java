package wholeapp;

public class Statistics {
	//==================================================
	public class BattleStatistics{
		private int firstBattle= 0;
		private int secondBattle= 0;
		private int thirdBattle= 0;
		private int counter=0;
		public BattleStatistics(){

		}
		
		public void addBattlePoints(int points){
			if(counter == 3)return;
			switch(counter){
			case 0:
				this.firstBattle = points;
				break;
			case 1:
				this.secondBattle = points;
				break;
			case 2:
				this.thirdBattle = points;
				break;
			}
			counter++;			
		}
		
		public boolean areBattlesDone(){
			return (counter == 3);
		}
		
		public int getTotalPoints(){
			return firstBattle+secondBattle+thirdBattle;
		}
		public String toString(){
			return  "BattleResult: "+this.getTotalPoints()+" [ "+firstBattle+" points | "+secondBattle+" points | "+thirdBattle+" points ]";
		}
		
	}
	//==================================================
	
	BattleStatistics battleStatistics = new BattleStatistics();
	
	public Statistics(){
		
	}

	public BattleStatistics getBattleStatistics() {
		return battleStatistics;
	}

	@Override
	public String toString() {
		return "Statistics [battleStatistics=" + battleStatistics.toString() + "]";
	}
	
	
	
	

}
