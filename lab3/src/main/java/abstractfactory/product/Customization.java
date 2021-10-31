package abstractfactory.product;

import lombok.Data;

@Data
public class Customization {
   private double extraMilk;
   private double Sugar;
   private double MugSize;

   public Customization(double extraMilk, double sugar, double mugSize) {
      this.extraMilk = extraMilk;
      Sugar = sugar;
      MugSize = mugSize;
   }
}
