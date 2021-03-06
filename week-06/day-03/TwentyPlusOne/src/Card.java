public class Card {
  private Suit suit;
  private Rank rank;

  public Card() {
    this.suit = Suit.randomSuit();
    this.rank = Rank.randomRank();
  }

  public Suit getSuit() {
    return suit;
  }

  public Rank getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return suit + " " + rank;
  }
}