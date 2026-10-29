# Art Exhibition — Bridge, Facade and Strategy

A Java console application that combines three design patterns
to present artworks in different formats and calculate their prices.

## Requirements

- JDK 25
- Maven

## Running

From the repository root:

```bash
cd BridgeFacadeStrategy/SDP3Bridge
mvn clean compile exec:java
```

## Design Patterns

### Bridge

`Exhibition` is the abstraction, with `Gallery` and `Museum`
as its subclasses.

It holds an `IObjectFormat` implementation: `Physical` or `Virtual`.
Exhibition types and presentation formats can vary independently.
The format can also change at runtime using `setFormat()`.

### Facade

`GalleryFacade` and `MuseumFacade` simplify creating, configuring
and presenting exhibitions.

For example, `presentVirtualGallery()` changes the format and
displays the gallery through one method call.

`presentWithPricing()` configures a pricing strategy and displays
the gallery using the resulting price.

### Strategy

`PricingStrategy` declares the shared `calculatedPrice()` method.

Concrete strategies:

- `RegularPricing`: returns the original price.
- `DiscountPricing`: subtracts a percentage.
- `CommissionPricing`: adds a percentage.
- `FixedDiscountPricing`: subtracts a fixed USD amount,
  with a minimum final price of zero.

`Gallery` is the Context. It stores a reference to `PricingStrategy`
and delegates price calculation to it.

`Main` is the Client. It selects and configures strategies,
passing them through `GalleryFacade`.

Strategies change at runtime on the same gallery object.
Every calculation uses the original base price, so changes
do not accumulate.

Pricing is calculated in USD. The existing `IPrice`
implementations then convert and format the result.
Exchange rates are fixed demonstration values.

## Clean Code Principles

1. Meaningful names:
   Names such as `DiscountPricing`, `discountPercent` and
   `basePrice` communicate their purpose.

2. Single Responsibility:
   Each pricing strategy encapsulates one pricing rule.
   Currency formatting is handled separately.

3. Polymorphism instead of conditional strategy selection:
   Gallery calls `pricingStrategy.calculatedPrice(priceUsd)`
   without checking the concrete strategy type.

4. Encapsulation:
   Strategy configuration fields are private and final.
   Constructor validation rejects invalid configuration.

5. Depend on abstractions:
   Gallery stores and accepts the `PricingStrategy` interface.
   Its calculation call works with every implementation.

6. Open/Closed Principle:
   New pricing rules can be added as new strategy classes
   without modifying Gallery, the Facade or existing strategies.

## Extensibility Demonstration

`FixedDiscountPricing` adds a fourth pricing rule.

Only the new strategy class and its selection in Main are needed.
The Context and Facade already support it through PricingStrategy.

For an original price of 100000 USD displayed using the
demonstration rate of 460 KZT per USD:

| Strategy | Result |
|---|---:|
| Regular | 46000000.00 KZT |
| Discount 10% | 41400000.00 KZT |
| Commission 15% | 52900000.00 KZT |
| Fixed discount 5000 USD | 43700000.00 KZT |

Switching back to RegularPricing restores 46000000.00 KZT.

## Console Output

Each presentation call prints the current gallery details.
Repeated artwork descriptions represent the same gallery
being displayed after configuration changes.
