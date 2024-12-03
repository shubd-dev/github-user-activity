# GitHub User Activity

A Java application for analyzing GitHub user activity. This project uses the [JSON-simple](https://code.google.com/archive/p/json-simple/) library to parse JSON data retrieved from GitHub's API.

---

## Project Overview
This application is part of the [roadmap.sh](https://roadmap.sh/projects/github-user-activity) backend roadmap project. It demonstrates how to fetch and process GitHub user data.

---

## Features
- Fetches GitHub user data using the GitHub API.
- Parses JSON responses with the `JSON-simple` library.
- Provides user-friendly output summarizing GitHub activity.

---

## How to Use
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd github-user-activity
   ```

2. **Run the Application**:
   - Compile the source code:
     ```bash
     javac -cp lib/json-simple.jar src/*.java
     ```
   - Execute the program:
     ```bash
     java -cp lib/json-simple.jar:src Main
     ```

3. **Provide a GitHub Username**:
   - Enter a GitHub username when prompted.
   - View the summarized GitHub activity in the output.

---

## Requirements
- Java Development Kit (JDK) 8 or higher.
- JSON-simple library (already included in the `lib` folder).
- Internet connection to access GitHub API.

---

## Roadmap.sh Reference
This project follows the backend developer roadmap guidelines outlined at [roadmap.sh](https://roadmap.sh/projects/github-user-activity).

---

## Example
```plaintext
Enter GitHub username: octocat
Fetching data...
GitHub User: octocat
Public Repos: 10
Followers: 150
Following: 2
Last Updated: 2024-12-01
```

---

## Contributing
Feel free to fork this repository, submit pull requests, or raise issues for suggestions and improvements.

---

## License
This project is open-source and available under the [MIT License](LICENSE).

---

## Acknowledgments
- [JSON-simple](https://code.google.com/archive/p/json-simple/) for JSON parsing.
- [GitHub API](https://docs.github.com/en/rest) for user data retrieval.
- [roadmap.sh](https://roadmap.sh) for the backend developer roadmap.
```
