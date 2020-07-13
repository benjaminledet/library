fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew install fastlane`

# Available Actions
## Android
### android deploy_internal
```
fastlane android deploy_internal
```
Publish a new version on github and an internal release on the google play store. You can specify upload_everything to true to upload all the medadata to the play store.
### android deploy_alpha
```
fastlane android deploy_alpha
```
Publish a new version on github and an alpha release on the google play store. You can specify upload_everything to true to upload all the medadata to the play store.
### android deploy_beta
```
fastlane android deploy_beta
```
Publish a new version on github and a beta release on the google play store. You can specify upload_everything to true to upload all the medadata to the play store.
### android deploy_production
```
fastlane android deploy_production
```
Publish a new version on github and a production release on the google play store. You can specify upload_everything to true to upload all the medadata to the play store.
### android publish
```
fastlane android publish
```
Publish a new version on github.
### android deploy_packages
```
fastlane android deploy_packages
```
Run the gradle task publishAllPublicationsToGithubPackagesRepository
### android deploy
```
fastlane android deploy
```
Deploy a new version to the google play store. You should specify a 'track' option which can be one of : [production, beta, alpha, internal]

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
