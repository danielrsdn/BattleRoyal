package model;

/**
 * The board class uses Square and Line classes to create the game board.
 * 	10.00 6 August 2020
 * 	@author Srishti Pahel, Sadia Saad
 *	Team D
 */
public class Board {
	
	private Square[] squares;

	/**
	 * This constructor allows to create and set the value of each index of the
	 * squares array
	 * 
	 * @param range        is the length of the line used to construct each square
	 *                     on the board
	 * @param centreXCoord is the centre x coordinate point of the square
	 * @param centreYCoord is the centre y coordinate point of the square
	 */
	public Board(double range, double centreXCoord, double centreYCoord) {
		squares = new Square[4];
		
		try {
			squares[0] = new Square("Outer Square", range, centreXCoord - range / 2, centreYCoord - range / 2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		range = range * (2.0 / 3);

		try {
			squares[1] = new Square("Middle Square", range, centreXCoord - range / 2, centreYCoord - range / 2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		range = range * 0.5;

		try {
			squares[2] = new Square("Inner Square", range, centreXCoord - range / 2, centreYCoord - range / 2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Line northMidLine = null;
		try {
			northMidLine = new Line("North Mid Line", squares[2].getLines()[3].getPoints()[1],
					squares[1].getLines()[3].getPoints()[1], squares[0].getLines()[3].getPoints()[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Line westMidLine = null;
		try {
			westMidLine = new Line("West Mid Line", squares[2].getLines()[1].getPoints()[1],
					squares[1].getLines()[1].getPoints()[1], squares[0].getLines()[1].getPoints()[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Line eastMidLine = null;
		try {
			eastMidLine = new Line("East Mid Line", squares[2].getLines()[2].getPoints()[1],
					squares[1].getLines()[2].getPoints()[1], squares[0].getLines()[2].getPoints()[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Line southMidLine = null;
		try {
			southMidLine = new Line("South Mid Line", squares[2].getLines()[0].getPoints()[1],
					squares[1].getLines()[0].getPoints()[1], squares[0].getLines()[0].getPoints()[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			squares[3] = new Square(northMidLine, westMidLine, eastMidLine, southMidLine);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Getter method to access all the squares on the game board
	 * 
	 * @return an array of squares that are used to build the game board.
	 */
	public Square[] getSquares() {
		return squares;
	}

	/**
	 * This method is used in the TextApplication controller to display all the
	 * points on any specific line
	 */
	public void displayBoard() {
		for (int i = 0; i < squares.length; i++) {
			System.out.println("Points on the North Lines: " + squares[i].getLines()[3].getPoints());
			System.out.println("Points on the East Lines: " + squares[i].getLines()[2].getPoints());
			System.out.println("Points on the West Lines: " + squares[i].getLines()[1].getPoints());
			System.out.println("Points on the South Lines: " + squares[i].getLines()[0].getPoints());
		}
	}

	/**
	 * This class can be used to locate the point on the board based on the x and y
	 * coordinates of the point.
	 * 
	 * @param xcor x coordinate of any of the points on the board
	 * @param ycor y coordinate of any of the points on the board
	 * @return
	 */
	public Point getPointByCoordinates(double xcor, double ycor) {
		Point answer = null;
		for (Square eachSquare : squares) {

			for (Line eachLine : eachSquare.getLines()) {

				for (Point eachPoint : eachLine.getPoints()) {

					if (eachPoint.getX() == xcor && eachPoint.getY() == ycor) {
						answer = eachPoint;
					}
				}
			}
		}

		return answer;
	}
}
