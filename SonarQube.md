# SonarQube Integration to Jenkins

> Below configurations are useful when you use SonarQube Server and jenkins


## SonarQube Server - Generate token

1. Sign up for a Github account

2. Login to [SonarQube.com](https://sonarqube.com/) using Github account

3. goto MyAccount and click on security tab

4. Generate security token by providing a token name (Ex: Webgoat)
    - Save token
    
## Jenkins global configuration

1. Install SonarQube plugin in jenkins

2. Goto Manage Jenkins -> Configure System -> SonarQube servers
    - Name
    - Server URL : [https://sonarqube.com/](https://sonarqube.com/)
    - Server version : 5.3 or higher
    - Server authentication token : Token created at SonarQube website
    - fell free to check with advanced options

## Jenkins job - configuration


