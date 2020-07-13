# Developer Guide

# Installation

Add a `.env` file on the root folder contening two variables :

`GITHUB_USER="..."`

`GITHUB_TOKEN="..."`

These are used by Fastlane and Gradle to publish the Github releases and packages.

# Commit
According to [conventional commits](https://www.conventionalcommits.org/en/v1.0.0/#summary), a commit must begin with one of the following keyword:

- `BREAKING CHANGE`: A commit that has a footer BREAKING CHANGE:, or appends a `!` after the type/scope, introduces a breaking API change (correlating with MAJOR in semantic versioning). A BREAKING CHANGE can be part of commits of any type.
- `chore`: updating grunt tasks etc; no production code change. `grunt task` means nothing that an external user would see.
- `docs`: Documentation only changes.
- `feat`: A new feature.
- `fix`: A bug fix.
- `perf`: A code change that improves performance.
- `refactor`: A code change that neither fixes a bug nor adds a feature.
- `style`: Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc).
- `test`: Adding missing tests or correcting existing tests.

Example: 

`feat: add fastlane`

# Version
The version is auto-incremented by fastlane when publishing a new release. The plugin combine the commits since the last release to determine the new version.

Patch (0.0.x): `fix`.

Minor (0.x.0): `feat`.

Major (x.0.0): add in the footer : `BREAKING CHANGE` or appends a `!` after the type.

The others keywords don't increment the version.

# Release
Run `fastlane publish_and_deploy_packages` to create a new Github release and publish the packages to Github Packages. The release is created with a changelog auto-generated from the commits.
