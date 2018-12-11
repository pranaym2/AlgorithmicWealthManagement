package com.example.pranaymerchant.algorithmicwealthmanagment;

public class Portfolio {

    double amountInvested;
    double riskPercentage;

    Stock[] stocks;

    public Portfolio(double amount, double risk, Stock[] s) {
        amountInvested = amount;
        riskPercentage = risk;
        stocks = s;
    }

    public String[] getPortfolio() {
        if (amountInvested > 10000) {
            String[] seventh = new String[1];
            seventh[0] = "Invalid inputs.";
            return seventh;
        }
        if (amountInvested <= 2000) {
            if (riskPercentage <= 4) {
                String[] first = new String[4];
                first[0] = "The best possible option: Invest " +  amountInvested + "in the Vanguard ETF.";
                first[1] = "The next viable option: Invest " +  amountInvested + " in the SPDR ETF.";
                first[2] = "The next viable option: Invest " +  amountInvested + " in the iShares ETF.";
                first[3] = "The next viable option: Invest in " + (amountInvested / 3) + " in each of the ETFs." ;
                return first;
            }
            if (riskPercentage > 4) {
                String[] second = new String[5];
                second[0] = "The best possible option: Invest " + amountInvested + " in the TD dividend.";
                second[1] = "The next viable option: Invest " + amountInvested + " in the O dividend.";
                second[2] = "The next viable option: Invest " + amountInvested + " in the wmt dividend.";
                second[3] = "The next viable option: Invest " + (amountInvested / 3) + " in each dividend stock.";
                second[4] = "The next viable option: Invest " + (amountInvested / 6) + " in each dividend stock and each ETF.";
                return second;
            }
        }
        if (amountInvested <= 5000 && amountInvested > 2000) {
            if (riskPercentage > 4) {

                String[] third = new String[5];
                double amountLeft = amountInvested;
                String starter = "The best possible option: Invest ";
                int i = 0;
                while(amountLeft > 0) {
                    Stock current = stocks[i];
                    starter = starter + current.getLatestValue() + " in " + current.getStockSymbol() + " stock,";
                    amountLeft = amountLeft - current.getLatestValue();
                    i++;
                }
                third[0] = starter;

                //1st option
                // Distribute evenly among the following Stocks:

                // CME Group (CME)
                //Cboe Global Markets Inc (CBOE)
                //U.S. Bancorp (USB)
                //MarketAxess (MKTX)
                //TD Ameritrade (AMTD)
                //StarBucks(SBUX)
                //NXP semiconductor(NXPI)
                //Facebook(FB)
                //Stitch Fix(SFIX)
                //Johnson and Johnson(JNJ)
                //Berkshire Hathaway(BRK.B, BRK.A)
                //Centene Corporation(CNC)
                //Apple (APPL)
                // How to distribute the Money:
                // start with investing 1 stock for each company by going down the list
                // each time counter of one stock increases decrease the investment amount by the CLOSING PRICE of the stock
                // once each stock has a counter of 1, repeat the process till the money left in the pool is less than the price of the next stock
                // at this point, rerun the loop to ensure that there can be no other investments made with the remaining money
                // spit out the following stocks with the counter and the left over money(if any)

                double three = amountInvested / 3;
                String n = "The next viable option: Invest " + third + " into SBUX, and the remaining split evently into NXP SemiConductor, MarketAxess.";
                third[1] = n;
                //2nd option
                // The first 2 stocks are high risk and high reward
                // Starbucks is there to minimize the risk provided from the other 2
                // 25% of money into NXP Semiconductor
                // 25% of money into MarketAxess
                // 25% of money into StarBucks
                // divide the rest of 25% among the remaining stocks

                third[2] = "The next viable option: Invest " + amountInvested + "into SXP Semiconductor.";
                // 3th option
                // invest all money into SXP Semiconductor
                third[4] = "The next viable option: Invest " + amountInvested + "into MarketAxess.";
                //4th option
                // invest all money into MarketAxess
                third[5] = "The next viable option: Invest " + amountInvested + "into Cboe Global Markets Inc.";
                // 5th options
                // invest all into Cboe Global Markets Inc (CBOE)
                third[5] = "The next viable option: Invest " + amountInvested + "into Stitch Fix(SFIX).";
                // 6th option
                // invest all into Stitch Fix(SFIX)
                third[5] = "The next viable option: Invest " + amountInvested + "into Centene Corporation(CNC).";
                // 7th option
                // invest all into Centene Corporation(CNC)
                return third;
            }
        }

        if (amountInvested <= 5000 && amountInvested > 2000) {
            if (riskPercentage <= 4) {
                String[] fourth = new String[8];
                fourth[0] = "The best possible option: Invest " +  amountInvested + "in the Vanguard ETF.";
                fourth[1] = "The next viable option: Invest " +  amountInvested + " in the SPDR ETF.";
                fourth[2] = "The next viable option: Invest " +  amountInvested + " in the iShares ETF.";
                fourth[3] = "The next viable option: Invest " + (amountInvested / 3) + " in each of the ETFs." ;
                fourth[4] = "The next viable option: Invest " + (amountInvested / 6) + " in each of the ETFs and " + (amountInvested / 2) + " into stocks.";
                fourth[5] = "The next viable option: Invest " + (3 * amountInvested / 4) + " in each of the ETFs and " + (amountInvested / 4) + " into stocks.";
                fourth[6] = "The next viable option: Invest " + ( amountInvested / 2) + " in each of the ETFs and " + (amountInvested / 2) + " into dividend stocks.";
                fourth[7] = "The next viable option: Invest " + ( amountInvested / 2) + " in each of the ETFs and " + (amountInvested / 4) + " into dividend stocks and " + (amountInvested / 4) + " into stocks.";
                //5th option
                // divide 50% of capital into the ETFs the rest 50% into Stocks(Stocks can be distributed evenly)
                //6th option (best option - should show first)
                // divide 25% into stocks and 75% into ETFs
                //7th options
                // 50 % into ETFS and 50% into dividend Stocks
                // 8th option
                // 25% into stocks, 25  % into dividend Stocks, 50 % into ETFs
                return fourth;
            }
        }
        if (amountInvested < 10000 && amountInvested > 5000) {
            if (riskPercentage <= 4) {
                String[] fifth = new String[10];
                fifth[0] = "The best possible option: Invest " +  amountInvested + "in the Vanguard ETF.";
                fifth[1] = "The next viable option: Invest " +  amountInvested + " in the SPDR ETF.";
                fifth[2] = "The next viable option: Invest " +  amountInvested + " in the iShares ETF.";
                fifth[3] = "The next viable option: Invest " + (amountInvested / 3) + " in each of the ETFs." ;
                fifth[4] = "The next viable option: Invest " + (amountInvested / 2) + " into ETFS and the rest into default stocks.";
                fifth[5] = "The next viable option: Invest " + (amountInvested / 4) + " into ETFS and the rest into default stocks.";
                fifth[6] = "The next viable option: Invest " + (amountInvested / 2) + " into ETFS and the rest into dividend stocks.";
                fifth[7] = "The next viable option: Invest " + (amountInvested / 2) + " into ETFS, " + (amountInvested / 4) + "into default stocks, and the rest into dividend stocks.";
                return fifth;
                // same as the above options, except for the best possible investment
                // first option
                //put all the money in vanguard
                //second option
                //put all in SPDR
                //third option
                //put all in ishares
                // 4th options
                // distribute evenly among the ETFS
                // Possible stocks to draw from with given amount:
                //CME Group
                //CBOE
                //U.S. Bancorp
                //MarketAxess
                //TD Ameritrade
                //StarBucks(SBUX)
                //NXP semiconductor(NXPI)
                //Facebook(FB)
                //Stitch Fix(SFIX)
                //Johnson and Johnson(JNJ)
                //Berkshire Hathaway(BRK.B, BRK.A)
                //Centene Corporation(CNC)
                //Apple (APPL)
                //Amazon(AMZN)
                //Baidu(BIDU)
                //Alibaba group holding(BABA)
                //StoneCo (STNE)
                //Adobe(ADBE)
                //Twitter(TWTR)
                //iQiyi(IQ)

                //5th option
                // divide 50% of capital into the ETFs the rest 50% into Stocks(Stocks can be distributed evenly)
                //6th option
                // divide 25% into stocks and 75% into ETFs
                //7th options
                // 50 % into ETFS and 50% into dividend Stocks
                // 8th option (Best possible - should be the one that shows first)
                // 25% into stocks, 25  % into dividend Stocks, 50 % into ETFs


            }
        }
        if (amountInvested <= 10000 && amountInvested >= 5000) {
            if (riskPercentage > 4) {
                String[] sixth = new String[4];
                double amountLeft = amountInvested;
                String starter = "The best possible option: Invest ";
                int i = 0;
                while(amountLeft > 0 && i < stocks.length) {
                    Stock current = stocks[i];
                    if (current == null) {
                        break;
                    }
                    starter = starter + current.getLatestValue() + " in " + current.getStockSymbol() + " stock,";
                    amountLeft = amountLeft - current.getLatestValue();
                    i++;
                }
                starter = starter + " and the rest in Starbucks (SBUX).";

                sixth[0] = starter;
                //1st option
                // distribute the following stocks evenly:
                //CME Group
                //CBOE
                //U.S. Bancorp
                //MarketAxess
                //TD Ameritrade
                //StarBucks(SBUX)
                //NXP semiconductor(NXPI)
                //Facebook(FB)
                //Stitch Fix(SFIX)
                //Johnson and Johnson(JNJ)
                //Berkshire Hathaway(BRK.B, BRK.A)
                //Centene Corporation(CNC)
                //Apple (APPL)
                //Amazon(AMZN)
                //Baidu(BIDU)
                //Alibaba group holding(BABA)
                //StoneCo (STNE)
                //Adobe(ADBE)
                //Twitter(TWTR)
                //iQiyi(IQ)
                amountLeft = amountInvested;

                ;
                sixth[0] = "The next possible option: Invest all in Vanguard";

                return sixth;
                // 5th otpion
                // 80 & into stocks and 20% into ETFs

            }

        }


        return null; //invalid inputs
    }
}