import java.util.Random;
import java.util.Scanner;

public class ChickenRPG {

	public static void main(String a[]) {
		
		char map [][] = new char[9][9];
		
		Random random = new Random();
		int chickenX=random.nextInt(9), chickenY = random.nextInt(9);

		int playerX=3, playerY=3;
		
		Scanner scan = new Scanner(System.in);
		
		
		for(int i=0; i<  map.length; ++i) {
			for(int j= 0; j< map.length; ++j) {
				map[i][j]='-';
			}
		}
		
		
		
		while(true) {
			
			map[chickenX][chickenY] = 'C';
			map[playerX][playerY] = 'P';
			
			
			
			if(playerX == chickenX && playerY == chickenY) {
				
				map[playerX][playerY] = 'X';
				printMap(map);
				System.out.println("You Won! Enjoy the chicken.");
				break;
			}
			
			printMap(map);
			
			System.out.println("Move Player (WASD or q):");
			char direction = scan.nextLine().toLowerCase().charAt(0);
			
			map[playerX][playerY] = '-';
			
			switch(direction) {
			case 'w':
				--playerX;
				break;
			case 'a':
				--playerY;
				break;
			case 's':
				++playerX;
				break;
			case 'd':
				++playerY;
				break;
			case 'q':
				return;
			}
			
			//Boundary check
			playerY = playerY < 0 ? 0 : playerY;
			playerY = playerY > 8 ? 8 : playerY;
			playerX = playerX < 0 ? 0 : playerX;
			playerX = playerX > 8 ? 8 : playerX;
			
			map[chickenX][chickenY] = '-';
			int dir = random.nextInt(3);
			
			switch(dir) {
			case 0:
				++chickenY;
				break;
			case 1:
				--chickenX;
				break;
			case 2:
				--chickenY;
				break;
			case 3:
				++chickenX;
				break;
			}
			//Boundary check
			chickenY = chickenY < 0 ? 0 : chickenY;
			chickenY = chickenY > 8 ? 8 : chickenY;
			chickenX = chickenX < 0 ? 0 : chickenX;
			chickenX = chickenX > 8 ? 8 : chickenX;
			
		}
		
		scan.close();
	}

	private static void printMap(char[][] map) {
		
		System.out.println("Map:");
		
		for(int i=0; i<  map.length; ++i) {
			for(int j = 0; j< map.length; ++j) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
}
