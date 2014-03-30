package wholeapp;

public class init {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub



		TrooperFactory trooperFactory = new TrooperFactory();
		Trooper trooper1 = trooperFactory.createTrooper(Domain.ENG,
				"example", null);


		try {
			trooper1.login();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
		do{
			try {
				trooper1.makeBattle();					
			} catch (BattleException e) {
				e.printStackTrace();
			}catch(NoMoreBattlesException e){
				break;
			}
		}while(true);
		

		System.out.println(trooper1.toString());
		
		
		
		
		
		
		
		
		
		

	}

}
