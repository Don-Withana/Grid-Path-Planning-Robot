# Grid-Path-Planning-Bot
An implementation of grid-based path planning algorithms for navigating robots through obstacles.

<!-- Improved compatibility of back to top link: See: https://github.com/Don-Withana/Grid-Path-Planning-Bot/pull/73 -->
<a id="readme-top"></a>
<!--
*** Thanks for checking out the Grid-Path-Planning-Bot. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a>
    <img src="https://github.com/Don-Withana/Grid-Path-Planning-Bot/blob/main/Grid-Logo.png" alt="Logo" width="250" height="255">
  </a>

  <h3 align="center">Efficient Path Planning for Autonomous Robot</h3>

</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#installation">Installation</a></li>
    <li><a href="#features">Features</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#example-output">Example Output</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>




<!-- ABOUT THE PROJECT -->
## About The Project

This project is a Java-based application designed to simulate a grid-based path planning scenario. The program allows users to define the size of a grid, place a robot and an end point, and then calculates the shortest path from the robot's starting position to the end point while avoiding obstacles placed randomly on the grid based on `Breadth-First Search (BFS)` algorithm.



### Built With

Java: The core programming language used for developing the grid path planning program, leveraging object-oriented principles for efficient pathfinding and grid management.
<br>
Console-Based UI: Utilizes Java’s standard input and output libraries to provide an interactive console-based user interface, enabling intuitive user input and visual grid representation.

[![java][java-shield]][java-url]

<!-- FEATURES -->
## Features

- **Customizable Grid Size:** Users can define the number of rows and columns for the grid (between 5 and 50).
- **Obstacle Placement:** The program randomly places obstacles on the grid while ensuring there is always a possible path from the robot to the end point.
- **Pathfinding Algorithm:** Utilizes a breadth-first search (BFS) algorithm to find the shortest path from the robot to the end point.
- **Interactive Console Input:** User-friendly prompts to input grid size, robot starting position, and end point position.
- **Visual Grid Display:** Displays the initial grid layout with coordinates, the robot's path, and obstacles.

<!-- INSTALLATION -->
## Installation

To run this project, ensure you have the following prerequisites:

- Java Development Kit (JDK) 8 or higher
- IDE or text editor of your choice (e.g., IntelliJ IDEA, Eclipse, VSCode)

### Steps to Set Up the Project

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/GridPathPlanning.git
    cd GridPathPlanning
    ```

2. **Compile the Java Files**:
    ```bash
    javac Main.java Grid.java RobotState.java
    ```

3. **Run the Program**:
    ```bash
    java Main
    ```

## Usage

Once the program is running:

1. **Input the Grid Dimensions**:
   - Enter the number of rows and columns (both between 5 and 50).

2. **Position the Robot**:
   - Enter the starting position for the robot (within the grid bounds).

3. **Set the End Point**:
   - Enter the coordinates for the end point (must be different from the robot's start position).

4. **View the Output**:
   - The program will display the grid, indicating the shortest path from the robot to the end point, avoiding obstacles.

## Example Output

```plaintext
★★★ Welcome to the Grid Path Planning Program ★★★ 

★ Enter the number of rows (between 5 and 50): 10
★ Enter the number of columns (between 5 and 50): 10

★ Enter the position of the robot:
    Row: 0
    Column: 0

★ Enter the position of the end point:
    Row: 9
    Column: 9

+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+
|  (0,0) |  (0,1) |  (0,2) |  (0,3) |  (0,4) |  (0,5) |  (0,6) |  (0,7) |  (0,8) |  (0,9) |
...
```  

<!-- CONTRIBUTING -->
## Contributing

Contributions are welcome! If you have ideas for new features or bug fixes, please fork the repository and submit a pull request. Here’s how:

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

This project is licensed under the MIT License. See the `LICENSE.txt` for more details. This means you can freely use, modify, and distribute the code, but please include the license notice in any copies or substantial portions of the software

<!-- CONTACT -->
## Contact

Have questions, suggestions, or just want to chat about the project? Reach out to me!

Name: Himan Withana
<br>
Email: himanhansadh.withana@gmail.com 

## Acknowledgments

Special thanks to the following resources and tools that have been invaluable in the creation and development of this project:

* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)
* [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)
* [GitHub Markdown Guide](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Don-Withana/Grid-Path-Planning-Bot.svg?style=for-the-badge
[contributors-url]: https://github.com/Don-Withana/Grid-Path-Planning-Bot/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Don-Withana/Grid-Path-Planning-Bot.svg?style=for-the-badge
[forks-url]: https://github.com/Don-Withana/Grid-Path-Planning-Bot/network/members
[stars-shield]: https://img.shields.io/github/stars/Don-Withana/Grid-Path-Planning-Bot.svg?style=for-the-badge
[stars-url]: https://github.com/Don-Withana/Grid-Path-Planning-Bot/stargazers
[issues-shield]: https://img.shields.io/github/issues/Don-Withana/Grid-Path-Planning-Bot.svg?style=for-the-badge
[issues-url]: https://github.com/Don-Withana/Grid-Path-Planning-Bot/issues
[license-shield]: https://img.shields.io/github/license/Don-Withana/Grid-Path-Planning-Bot.svg?style=for-the-badge
[license-url]: https://github.com/Don-Withana/Grid-Path-Planning-Bot/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/himanwithana
[java-shield]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[java-url]: https://www.java.com/en/
