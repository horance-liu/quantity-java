package quantity

import spock.lang.Specification

import static quantity.Length.*

class LengthSpec extends Specification {
  def "1 feet == 12 inch"() {
    expect:
    feet(1) == inch(12)
    feet(1) != inch(10)
  }

  def "1 yard == 3 feet"() {
    expect:
    yard(1) == feet(3)
    yard(1) != feet(2)
  }

  def "1 mile == 1760 yard"() {
    expect:
    mile(1) == yard(1760)
    mile(1) != yard(2760)
  }

  def "1 mile == (1760 * 3 * 12) inch"() {
    expect:
    mile(1) == inch(1760 * 3 * 12)
  }
}
