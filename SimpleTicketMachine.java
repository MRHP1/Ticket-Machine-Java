/**
 * SimpleTicketMachine models a basic ticket machine that sells tickets
 * at a fixed price. Users are expected to enter the correct amount.
 * No sophisticated checks are performed.
 * 
 * @author Refactor
 * @version 2024.09.19
 */
public class SimpleTicketMachine
{
    // The price of a single ticket.
    private int ticketPrice;
    // The current balance of the user's inserted money.
    private int currentBalance;
    // The total revenue collected by the machine.
    private int totalRevenue;
    
    /**
     * Create a ticket machine that sells tickets at a specific price.
     * @param price the cost of a ticket
     */
    public SimpleTicketMachine(int price)
    {
        ticketPrice = price;
        currentBalance = 0;
        totalRevenue = 0;
    }
    
    /**
     * Get the price of a single ticket.
     * @return the ticket price
     */
    public int getTicketPrice()
    {
        return ticketPrice;
    }
    
    /**
     * Get the total money inserted for the current transaction.
     * @return the current balance
     */
    public int getCurrentBalance()
    {
        return currentBalance;
    }
    
    /**
     * Insert money into the machine.
     * Only positive amounts are accepted.
     * @param amount the amount to be inserted
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            currentBalance += amount;
        } else {
            System.out.println("Please insert a positive amount.");
        }
    }
    
    /**
     * Print a ticket if enough money has been inserted.
     * Otherwise, inform the user of how much more is needed.
     */
    public void printTicket()
    {
        if(currentBalance >= ticketPrice) {
            System.out.println("**************");
            System.out.println("* Ticket *");
            System.out.println("* Price: " + ticketPrice + " *");
            System.out.println("**************");
            totalRevenue += ticketPrice;
            currentBalance -= ticketPrice;
        } else {
            int deficit = ticketPrice - currentBalance;
            System.out.println("You need " + deficit + " more to buy the ticket.");
        }
    }
    
    /**
     * Refund the balance if any.
     * @return the refunded balance
     */
    public int refundBalance()
    {
        int amountToRefund = currentBalance;
        currentBalance = 0;
        if(amountToRefund > 0) {
            System.out.println("Refunding: " + amountToRefund);
        }
        return amountToRefund;
    }
    
    /**
     * Get the total revenue collected by the machine.
     * @return the total revenue
     */
    public int getTotalRevenue()
    {
        return totalRevenue;
    }
}
