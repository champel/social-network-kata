Social network kata following IDD
=================================

Based on the [Sandro Mancuso's kata](https://github.com/sandromancuso/social_networking_kata/blob/master/README.md)

### Used development environment to do the Kata

* Java 11 (adopt openjdk)
* Eclipse 2020-09
* Apache Maven 3.5.4

### Libraries

Libraries have been constrained to be aligned with my employer.

* JUnit 5.7.0 (jupiter)
* AssertJ 3.8.1
* Mockito 3.6.28
* Cucumber 6.9.0 (java8/lambda StepsDef support)

### The Kata

Start using the skeleton branch. An implementation following [IDD](https://www.codurance.com/publications/2017/12/08/introducing-idd) & [Outside-in](https://www.codurance.com/publications/2017/10/23/outside-in-design) TDD is depicted in steps accessible as branches:

* 00 - Skeleton, defining:
    * Console [delivery mechanism](http://www.codingthearchitecture.com/2011/11/06/the_delivery_mechanism_is_an_annoying_detail.html), based on a [simple library](https://github.com/champel/console-app) that allows to inject command builders and formatters.
    * Console end to end [Scenario Test](https://martinfowler.com/bliki/StoryTest.html), expected to be full stack. See: <code>features/delivery/console/end-2end/*.feature</code> & <code>ConsoleAppE2EAT</code>
    * A [clock wrapper](https://martinfowler.com/bliki/ClockWrapper.html) is defined to [eradicate non determinism in tests](https://martinfowler.com/articles/nonDeterminism.html)
    * A user journey initial test for the basic 'exit' scenario. See: <code>features/delivery/console/user-journey/*.feature</code> & <code>ConsoleUserJourneyAT</code>
* 10 - User commands implementation with [User Journey Test](https://martinfowler.com/bliki/UserJourneyTest.html) in GREEN & Actions sketch discovery
* 20 - Actions implementation, [Action Components Test](https://martinfowler.com/bliki/ComponentTest.html) creation & Domain services sketch discovery
* 40 - Domain services implementations, Action Components Acceptance Test in GREEN
* 50 - Repository implementation & [Integration Test](https://martinfowler.com/bliki/IntegrationTest.html) in GREEN based on expected interface behavior (pending to apply [Contract Test](https://martinfowler.com/bliki/ContractTest.html)).
* 60 - End to end test in GREEN

### Eclipse tricks

#### Configure static imports

In <code>Preferences/Java/Editor/Content Asist/Favorites</code>, introduce the following favorites (I also removed the previous ones):
* org.assertj.core.api.Assertions
* org.mockito.ArgumentMatchers
* org.mockito.BDDMockito
* org.mockito.Mockito

#### Some helpful keyboard shortcuts

* <kbd>command</kbd>+<kbd>1</kbd> Quick fix. Very useful when you have a lot of red in your tests :) (thanks Sandro!)
* <kbd>command</kbd>+<kbd>shift</kbd>+<kbd>R</kbd> Search dialog for resources
* <kbd>command</kbd>+<kbd>shift</kbd>+<kbd>T</kbd> Search dialog for java types
* <kbd>command</kbd>+<kbd>shift</kbd>+<kbd>O</kbd> Search/Clean/Organize imports
* <kbd>command</kbd>+<kbd>F11</kbd> Run last launched

For windows, use <kbd>control</kbd> instead of <kbd>command</kbd>

[More shorcuts](https://www.vogella.com/tutorials/EclipseShortcuts/article.html)
