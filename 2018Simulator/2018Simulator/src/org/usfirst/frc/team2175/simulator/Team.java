package org.usfirst.frc.team2175.simulator;

import java.util.Random;

public class Team
{

	Random r = new Random();

	Vault vault = new Vault();

	double fieldWidth = 100;
	double fieldLength = 200;

	// definition of board x = width, y = length

	// blue top left is 0,0
	// red bottom left is width,0

	// blue top right is 0,length
	// right bottom right = width,length

	Robot[] robots = new Robot[3];

	int score = 0;

	int color;

	public Team(int col)
	{
		color = col;

		initialize();

	}

	public void initialize()
	{
		if (color == Game.RED)
		{

			robots[0] = new Robot(180.0,80.0, this, 0);
			robots[1] = new Robot(180.0,250.0,this, 1);
			robots[2] = new Robot(180,360, this, 2);
		}
		else
		{
			robots[0] = new Robot(980, 75, this, 0);
			robots[1] = new Robot(980, 160, this, 1);
			robots[2] = new Robot(980, 380, this, 2);

		}
		score = 0;
		vault.initialize();
	}

	public int getVaultScore()
	{
		return vault.score;

	}
	
	public int getForceCount()
	{
		return vault.getForceCount();
	}
	public int getBoostCount()
	{
		return vault.getBoostCount();
	}
	public int getLevitateCount()
	{
		return vault.getLevitateCount();
	}

	public void incrementScore(int amount)
	{
		score += amount;
	}

	public void move(double gameTime)
	{
		for (int i = 0; i < robots.length; i++)
		{
			
			Robot robot = robots[i];
			robot.move(gameTime);
		}
		
	}

	public Robot[] getRobots()
	{
		return robots;
	}
}
