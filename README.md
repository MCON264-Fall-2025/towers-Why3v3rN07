recursion-starter-repo

This repository contains a Maven multi-module project with a single module `recursion`.

What I changed
- Added a root `pom.xml` (packaging `pom`) that declares the `recursion` module.
- Updated `recursion/pom.xml` to declare the root `pom.xml` as its `<parent>` and removed redundant `groupId`/`version` so it inherits them.

How to build locally
1. Ensure you have Java 21 and Maven installed (Maven 3.8+ recommended).
2. From the repository root, run:

   mvn -DskipTests package

   This will build the parent and the `recursion` module and produce artifacts under `recursion/target`.

3. To run tests:

   mvn test

Notes and troubleshooting
- If your IDE still doesn't recognize the module, try: `mvn -U clean package` or reimport the Maven project in your IDE.
- The CI environment used to run the build must support Java 21. If you need compatibility with earlier Java versions, update the compiler properties in the root `pom.xml` and module `pom.xml`.

Status
- Module wiring: Done
- Local build (performed here): Deferred due to terminal limitations in this environment; instructions above let you run it locally.



