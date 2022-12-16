import java.util.Scanner;
/**
 * @author Mohammad varrel bramasta - 2106733811
 * @author Rakha argya zahran - 2106733925
 * @author Enricco Verindra putra - 2106651793
 * @version 1.0
 */
public class SavingsAccount {
    private float balance;

    /**
     * Fungsi untuk menarik uang dari rekening tabungan
     * @param anAmount
     */
    public void withdraw(float anAmount) {
        if (anAmount < 0.0) {
            throw new IllegalArgumentException("Penarikan Uang negative");
        }

//        synchronized (this) {
//            if (anAmount <= balance) {
//                 balance = balance - anAmount;
//            }
//        }

        if (anAmount <= balance) {
            synchronized (this) {
                balance = balance - anAmount;
            }
        }

    }

    /**
     * Fungsi untuk menambahkan saldo ke balance
     * @param anAmount
     */
    public void deposit(float anAmount) {
        if (anAmount < 0.0) {
            throw new IllegalArgumentException("Penarikan Uang Positve");
        }
        synchronized (this) {
            balance = balance + anAmount;
        }
    }

    public float getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        SavingsAccount acc = new SavingsAccount();

        System.out.print("Masukan Uang yang akan didepositkan : ");
        int deposit = new Scanner(System.in).nextInt();
        // int deposit = 2000;
        Thread trd1 = new Thread(() -> {
            acc.deposit(deposit);
            System.out.println("Thread 1: Deposit "+ deposit + " dari account");
        });


        System.out.print("Masukan Uang yang akan ditarik      : ");
        int penarikan = new Scanner(System.in).nextInt();
        // int penarikan = 450;
        Thread trd2 = new Thread(() -> {
            acc.withdraw(penarikan);
            System.out.println("Thread 2: Penarikan "+ penarikan + " dari account");
        });

        trd1.start();
        trd2.start();

        try {
            trd1.join();
            trd2.join();
        } catch (InterruptedException e) {
            System.out.println("Error..");
        }

        System.out.println("Balance akhir : " + acc.getBalance());
    }
}