package com.softvision.programmingPractice.oopPractice;

public class Printer {

    private int tonerLevel; // percent available
    private int paperSheetCapacity; // number of paper sheets
    private int paperSheets;
    private int pagesPrinted;
    private boolean isDuplexPrinter;

    /*
        I will assume that printing one side of a page will consume 1 ink unit
     */

    public Printer(int paperSheetCapacity, boolean isDuplexPrinter) {

        this.tonerLevel = 0;
        this.paperSheetCapacity = paperSheetCapacity;
        this.paperSheets = 0;
        this.pagesPrinted = 0;
        this.isDuplexPrinter = isDuplexPrinter;
    }

    public void fillTonerUp(int inkUnits) {

        if (inkUnits + this.tonerLevel > 100) {
            System.out.println("Tonner overflow");
        } else {
            this.tonerLevel += inkUnits;
        }
    }

    public void fillPaperUp(int sheetNumber) {

        if (this.paperSheets + sheetNumber > this.paperSheetCapacity) {
            System.out.println("Paper overflow");
        } else {
            this.paperSheets += sheetNumber;
        }
    }

    public void print(int pageNumber) {

        int sheetsNeeded;

        if (pageNumber > tonerLevel) {
            System.out.println("There is not enough ink. Please refill. Operation aborted.");
            return;
        }

        if (this.isDuplexPrinter) {
            sheetsNeeded = pageNumber / 2 + pageNumber % 2;
        } else {
            sheetsNeeded = pageNumber;
        }

        if (sheetsNeeded > paperSheets) {
            System.out.println("There is not enough paper. Please refill. Operation aborted.");
            return;
        }

        this.tonerLevel -= pageNumber;
        this.paperSheets -= sheetsNeeded;
        this.pagesPrinted += pageNumber;
    }
}
