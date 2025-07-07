# Attack-On-Titans-Utopia

A 1-Player, endless, tower defense game inspired by the hit anime "Attack On Titan". Defend humanity's last stronghold by strategically placing weapons and managing resources while waves of titans approach your walls.

## 🎮 Game Overview

Attack-On-Titans-Utopia is a JavaFX-based tower defense game where players must defend multiple lanes from approaching titans. The game features progressive difficulty through three distinct battle phases, various titan types with unique abilities, and strategic weapon placement mechanics.

## ✨ Key Features

### Battle System
- **3 Battle Phases**: Early, Intense, and Grumbling phases with increasing difficulty
- **Progressive Scaling**: Number of titans doubles every 5 turns after turn 30
- **Multiple Lanes**: Defend several lanes simultaneously with varying danger levels
- **Resource Management**: Earn resources by defeating titans to purchase weapons

### Titans
- **Pure Titan**: Basic enemy with standard health and damage
- **Abnormal Titan**: Faster movement with unpredictable behavior
- **Armored Titan**: Heavy armor with high health but slower movement
- **Colossal Titan**: Massive titan with devastating damage capability

### Weapons Arsenal
- **Sniper Cannon**: Long-range precision weapon
- **Piercing Cannon**: High-damage weapon effective against armored targets
- **Volley Spread Cannon**: Area-of-effect weapon for multiple targets
- **Wall Trap**: Defensive weapon placed on walls

### Game Mechanics
- **Lane Priority System**: Titans automatically target the lane with the lowest danger level
- **Wall Health**: Each lane has a wall that titans must breach to win
- **Dynamic Difficulty**: Game adapts based on performance and turn progression
- **Score Tracking**: Points awarded for defeated titans and efficient resource management

## 🏗️ Project Architecture

```
src/
├── game/
│   ├── engine/           # Core game logic
│   │   ├── base/         # Base game components (Wall, etc.)
│   │   ├── dataloader/   # CSV data loading utilities
│   │   ├── exceptions/   # Custom exception classes
│   │   ├── interfaces/   # Game interfaces
│   │   ├── lanes/        # Lane management system
│   │   ├── titans/       # Titan classes and registry
│   │   ├── weapons/      # Weapon classes and factory pattern
│   │   └── Battle.java   # Main battle controller
│   │
│   ├── gui/              # JavaFX user interface
│   │   ├── controller/   # Application controllers
│   │   ├── model/        # UI data models
│   │   ├── views/        # Scene views and layouts
│   │   ├── contentNeeded/# Assets (images, fonts)
│   │   └── styles.css    # UI styling
│   │
│   └── tests/            # Comprehensive test suites
│       ├── Milestone1PublicTests.java
│       ├── Milestone1PrivateTests.java
│       ├── Milestone2PublicTests.java
│       └── Milestone2PrivateTests.java
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- JavaFX runtime (if not included with your JDK)
- Any Java IDE (IntelliJ IDEA, Eclipse, VSCode)

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Attack-On-Titans-Utopia
   ```

2. **Configure your IDE**
   - Import the project as a Java project
   - Ensure JavaFX libraries are properly configured
   - Set the main class to `game.gui.controller.gui`

3. **Data Files**
   - `titans.csv`: Contains titan statistics and configurations
   - `weapons.csv`: Contains weapon data and pricing information

### Running the Game

#### From IDE
- Run the main class: `game.gui.controller.gui`

#### From Command Line
```bash
# Compile the project
javac -cp ".:path/to/javafx/lib/*" src/game/gui/controller/gui.java

# Run the game
java -cp ".:path/to/javafx/lib/*" --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml game.gui.controller.gui
```

## 🎯 Gameplay Guide

### Starting a Game
1. Launch the application
2. Navigate through the main menu
3. Begin with the tutorial or start a new battle

### Basic Strategy
1. **Monitor Lane Danger**: Keep an eye on lane danger levels
2. **Resource Management**: Balance weapon purchases with defensive needs
3. **Weapon Placement**: Position weapons strategically for maximum coverage
4. **Phase Preparation**: Prepare for increasing difficulty in later phases

### Game Progression
- **Turns 1-14**: Early phase with basic titans
- **Turns 15-29**: Intense phase with stronger enemies
- **Turn 30+**: Grumbling phase with massive titan waves

## 🧪 Testing

The project includes comprehensive test suites:

```bash
# Run milestone tests
java -cp ".:junit.jar" org.junit.runner.JUnitCore game.tests.Milestone1PublicTests
java -cp ".:junit.jar" org.junit.runner.JUnitCore game.tests.Milestone2PublicTests
```

## 📊 Game Data

### Titans Configuration (titans.csv)
```
ID,Health,Damage,Speed,Armor,Resources,Type
1,100,15,15,10,10,1
2,100,20,10,15,15,2
3,200,85,15,10,30,3
4,1000,100,60,5,60,4
```

### Weapons Configuration (weapons.csv)
```
ID,Price,Damage,Name,[Area],[Range]
1,25,10,Anti Titan Shell
2,25,35,Long Range Spear
3,100,5,Wall Spread Cannon,20,50
4,75,100,Proximity Trap
```

## 🛠️ Technical Features

- **Factory Pattern**: Weapon creation and management
- **Observer Pattern**: UI updates and game state management
- **Priority Queue**: Lane danger level management
- **MVC Architecture**: Clean separation of concerns
- **Exception Handling**: Robust error management
- **JavaFX Properties**: Reactive UI updates

## 🎨 Assets & Resources

- Custom fonts (Ditty, Dutch Brigade)
- High-quality game images and icons
- Themed UI styling matching Attack on Titan aesthetic
- Responsive layout design

## 📝 Development Milestones

The project is structured around development milestones:
- **Milestone 1**: Core game engine and basic mechanics
- **Milestone 2**: GUI implementation and advanced features
- **Milestone 3**: Polish, optimization, and final features

## 🤝 Contributing

This project follows academic development standards with comprehensive testing and documentation. Please ensure all tests pass before submitting any changes.

## 📄 License

Academic project - refer to your institution's policies regarding code sharing and academic integrity.

---

*Defend humanity's last hope against the titan threat! Will you be able to protect the walls and ensure humanity's survival?*
