/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.racepacecalculator;

import java.util.Scanner;

public class RacePaceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part a: Calculate Race Pace
        System.out.print("Enter the race distance (in kilometres): ");
        double raceDistanceKm = scanner.nextDouble();

        System.out.print("Enter your finish time (as hh:mm:ss). Include zeros if applicable: ");
        scanner.nextLine();  
        String finishTimeInput = scanner.nextLine();

        // Parse finish time input
        String[] timeParts = finishTimeInput.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);

        // Calculate total time in minutes
        double totalTimeMinutes = hours * 60 + minutes + seconds / 60.0;

        // Calculate pace per km and per mile
        double pacePerKm = totalTimeMinutes / raceDistanceKm;
        double pacePerMile = totalTimeMinutes / (raceDistanceKm * 0.621371); // 1 km = 0.621371 miles

        // Format pace and print
        String pacePerKmFormatted = String.format("%.1f", pacePerKm);
        String pacePerMileFormatted = String.format("%.1f", pacePerMile);
        System.out.println("Your race pace was " + pacePerKmFormatted + " per km or " + pacePerMileFormatted + " per mile.");

        // Part b: Predict Finish Times
        System.out.print("\nEnter your 1-mile time, to the nearest second, as mm:ss. Include zeros if applicable: ");
        String mileTimeInput = scanner.nextLine();

        // Parse mile time input
        String[] mileTimeParts = mileTimeInput.split(":");
        int mileMinutes = Integer.parseInt(mileTimeParts[0]);
        int mileSeconds = Integer.parseInt(mileTimeParts[1]);

        // Predict finish times for various distances
        double predicted5KTimeMinutes = (mileMinutes + mileSeconds / 60.0) * (5.0 / 1.60934); // Convert to km
        double predicted10KTimeMinutes = predicted5KTimeMinutes * 2;
        double predictedHalfMarathonTimeMinutes = predicted5KTimeMinutes * (13.1 / 5.0);
        double predictedMarathonTimeMinutes = predicted5KTimeMinutes * (26.2 / 5.0);

        // Format predicted times and print
        String predicted5KTimeFormatted = formatTime(predicted5KTimeMinutes);
        String predicted10KTimeFormatted = formatTime(predicted10KTimeMinutes);
        String predictedHalfMarathonTimeFormatted = formatTime(predictedHalfMarathonTimeMinutes);
        String predictedMarathonTimeFormatted = formatTime(predictedMarathonTimeMinutes);

        System.out.println("\nYour predicted 5 km time is " + predicted5KTimeFormatted + ".");
        System.out.println("Your predicted 10 km time is " + predicted10KTimeFormatted + ".");
        System.out.println("Your predicted half marathon time is " + predictedHalfMarathonTimeFormatted + ".");
        System.out.println("Your predicted marathon time is " + predictedMarathonTimeFormatted + ".");

        System.out.println("\nProgram terminated normally.");
        scanner.close();
    }

    // Method to format time as mm:ss
    private static String formatTime(double timeMinutes) {
        int minutes = (int) timeMinutes;
        int seconds = (int) ((timeMinutes - minutes) * 60);
        return String.format("%02d:%02d", minutes, seconds);
    }
}

