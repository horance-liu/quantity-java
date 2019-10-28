package quantity;

public final class Length {
  private final int amountInBaseUnit;

  private Length(int amount, LengthUnit unit) {
    this.amountInBaseUnit = unit.amountInBaseUnit(amount);
  }

  public static Length mile(int amount) {
    return new Length(amount, LengthUnit.MILE);
  }

  public static Length yard(int amount) {
    return new Length(amount, LengthUnit.YARD);
  }

  public static Length feet(int amount) {
    return new Length(amount, LengthUnit.FEET);
  }

  public static Length inch(int amount) {
    return new Length(amount, LengthUnit.INCH);
  }

  @Override
  public boolean equals(Object obj) {
    if (getClass() != Length.class) {
      return false;
    }
    Length other = (Length)obj;
    return amountInBaseUnit == other.amountInBaseUnit;
  }

  private enum LengthUnit {
    INCH(1),
    FEET(12, INCH),
    YARD(3, FEET),
    MILE(1760, YARD);

    private int amountInBaseUnit(int amount) {
      return amount * factor;
    }

    private LengthUnit(int factor, LengthUnit child) {
      this.factor = factor * child.factor;
    }

    private LengthUnit(int factor) {
      this.factor = factor;
    }

    private int factor;
  }
}
