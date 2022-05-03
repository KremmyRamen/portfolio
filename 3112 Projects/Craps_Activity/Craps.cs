//Raymond Nguyen//
using System; //Required

namespace Craps //Context
{
    class Craps //Main Class
    {
        
        static void Main(string[] args) //Main
        {
            int Roll, Wager, Point = 0, Chips = 100; //Initializing and Declaring variables
            bool Playing = true, SecondRoll = false;
            char cont;
            Random rand = new Random();

            Console.WriteLine("Welcome to Craps"); //Welcome message

            while (Playing != false && Chips != 0) //Allows for looping of Craps game 
            {
                Console.WriteLine("You have " + Chips + " chips.");
                Console.Write("Continue? Type `y` for continue or `n` for stop"); 
                cont = char.Parse(Console.ReadLine());

                    if (cont.Equals('n'))
                    {
                        Console.WriteLine("You have left with " + Chips + " remaining chips! Goodbye!");
                        Environment.Exit(0);
                    }
                    else if (cont.Equals('y'))
                    {
                        
                    }
                    else if (cont != 'y'|| 'n')
                    {
                        Console.WriteLine("Invalid input. Type `y` for continue or `n` for stop");       
                    }              

                Console.Write("How much do you want to wager: "); //Gets a wager
                Wager = int.Parse(Console.ReadLine()); //Reads the wager into the variable
                while(Wager > Chips) //Will not accept wagers above the current chip value
                {
                    Console.WriteLine("You do not have enough chips for that wager."); //Displays appropriate lines
                    Console.Write("How much do you want to wager: ");
                    Wager = int.Parse(Console.ReadLine());
                }


                Console.WriteLine("Time to roll! Press spacebar to roll."); //Allows the user to press spacebar to roll

                while(Console.ReadKey(false).Key != ConsoleKey.Spacebar) //Only rolls if the user pressed the spacebar
                {
                }
                
                Roll = rand.Next(1, 7)+rand.Next(1, 7); //Rolling the die

                Console.WriteLine("You rolled "+Roll+"!"); //Displays the roll
                
                switch (Roll) //For displaying the results of the die. This is the win, lose, and continue situations for the first roll
                {
                    case 7: //Win if the roll is 7 or 11
                    case 11:
                        Console.WriteLine("You Won!");
                        Chips += Wager;
                        break;
                    case 2: //Lose if the roll is 2, 3, or 12
                    case 3:
                    case 12:
                        Console.WriteLine("You Lost!");
                        Chips -= Wager;
                        break;
                    default:
                        Console.WriteLine("Your point is " + Roll + "."); //Displays the new point goal if any other number
                        Point = Roll;
                        SecondRoll = true;
                        break;
                }

                while (SecondRoll) //For displaying the results of the die. This is the win, lose, and continue situations for the second roll
                {
                    Console.WriteLine("Roll again! Press spacebar to roll.");

                    while (Console.ReadKey(false).Key != ConsoleKey.Spacebar)
                    {
                    }

                    Roll = rand.Next(1, 7) + rand.Next(1, 7); //Rolls two die

                    Console.WriteLine("You rolled " + Roll + "!");

                    switch (Roll) //Win and lose condition for the second part of the game
                    {
                        case 7:
                            Console.WriteLine("You Lost!");
                            Chips -= Wager;
                            SecondRoll = false;
                            break;
                        case var value when value == Point:
                            Console.WriteLine("You Won!");
                            Chips += Wager;
                            SecondRoll = false;
                            break;
                        default:
                            break;
                    }
                }    
            } 
            if (Chips == 0)
                Console.WriteLine("You have no Chips! Goodbye!");
        }
    }
}