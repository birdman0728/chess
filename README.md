# ♕ BYU CS 240 Chess

This project demonstrates mastery of proper software design, client/server architecture, networking using HTTP and WebSocket, database persistence, unit testing, serialization, and security.

## 10k Architecture Overview

The application implements a multiplayer chess server and a command line chess client.

[![Sequence Diagram](10k-architecture.png)](https://sequencediagram.org/index.html#initialData=C4S2BsFMAIGEAtIGckCh0AcCGAnUBjEbAO2DnBElIEZVs8RCSzYKrgAmO3AorU6AGVIOAG4jUAEyzAsAIyxIYAERnzFkdKgrFIuaKlaUa0ALQA+ISPE4AXNABWAexDFoAcywBbTcLEizS1VZBSVbbVc9HGgnADNYiN19QzZSDkCrfztHFzdPH1Q-Gwzg9TDEqJj4iuSjdmoMopF7LywAaxgvJ3FC6wCLaFLQyHCdSriEseSm6NMBurT7AFcMaWAYOSdcSRTjTka+7NaO6C6emZK1YdHI-Qma6N6ss3nU4Gpl1ZkNrZwdhfeByy9hwyBA7mIT2KAyGGhuSWi9wuc0sAI49nyMG6ElQQA)

## IntelliJ Support

Open the project directory in IntelliJ in order to develop, run, and debug your code using an IDE.

## Maven Support

You can use the following commands to build, test, package, and run your code.

| Command                    | Description                                     |
| -------------------------- | ----------------------------------------------- |
| `mvn compile`              | Builds the code                                 |
| `mvn package`              | Run the tests and build an Uber jar file        |
| `mvn package -DskipTests`  | Build an Uber jar file                          |
| `mvn install`              | Installs the packages into the local repository |
| `mvn test`                 | Run all the tests                               |
| `mvn -pl shared tests`     | Run all the shared tests                        |
| `mvn -pl client exec:java` | Build and run the client `Main`                 |
| `mvn -pl server exec:java` | Build and run the server `Main`                 |

These commands are configured by the `pom.xml` (Project Object Model) files. There is a POM file in the root of the project, and one in each of the modules. The root POM defines any global dependencies and references the module POM files.

### Running the program using Java

Once you have compiled your project into an uber jar, you can execute it with the following command.

```sh
java -jar client/target/client-jar-with-dependencies.jar

♕ 240 Chess Client: chess.ChessPiece@7852e922
```

This is the link to the design
https://sequencediagram.org/index.html?presentationMode=readOnly#initialData=IYYwLg9gTgBAwgGwJYFMB2YBQAHYUxIhK4YwDKKUAbpTngUSWDAEooDmSAzmFMARDQVqhFHXyFiwUgBF+wAIIgQKLl0wATeQCNgXFDA3bMmdlAgBXbDADEaYFQCerDt178kg2wHcAFkjAxRFRSAFoAPnJKGigALhgAbQAFAHkyABUAXRgAegt9KAAdNABvfMp7AFsUABoYXDVvaA06lErgJAQAX0xhGJgIl04ePgEhaNF4qFceSgAKcqgq2vq9LiaoFpg2joQASkw2YfcxvtEByLkwRWVVLnj2FDAAVQKFguWDq5uVNQvDbTxMgAUQAMsC4OkYItljAAGbmSrQgqYb5KX5cAaDI5uUaecYiFTxNAWBAIQ4zE74s4qf5o25qeIgab8FCveYw4DVOoNdbNL7ydF3f5GeIASQAciCWFDOdzVo1mq12p0YJL0ilkbQcSMPIIaQZBvSMUyWYEFBYwL53hUuSgBdchX9BqK1VLgTKtUs7XVgJbfOkIABrdBujUwP1W1GChmY0LYyl4-UTIkR-2BkNoCnHJMEqjneORPqUeKRgPB9C9aKULGRYLoMDxABMAAYW8USmWM+geugNCYzJZrDZoNJHjBQRBOGgfP5Aph62Ei9W4olUhlsjl9Gp8R25SteRsND1i1AIjqqcnCSh4uyoN8bd7uYf+dncXq8wXwsa7vELVaH33Hk1iPB0fmFCJXUlaUoS7CsswvXMDRgAAeeMf0ZGA0BQbw0ytbss1PNDQkQj8DVLdN4IXZAG2I09mzbDs4MzXs0H7UxzCsWwzBQUNJ3YSxmBsPwAiCGilyiagS0SGQwWBdJgU3bcuF3exKMzKspNgc9EzIlMbxgBAp0EuZmPQA5SNOfSLgw+5DBQBAnhQf9fGjR1YwuUVZPBBS8PLDTLOpfTiNs2JNP6YjAqvfMiWokJmDolcGJbTA+wHTjh2mDQJzcGAAHE7UxYS5zE+L-noxI8vkzd2DtYozMIlcLiiz9U2QHgCuqLhTPU8y311KzrwiULQTcTrVDc8C-mI11gDJcb1Ba5C0NCkoYAAIlqrr1viBISk2u0xRkHaYAARibABmAAWOp1pEwI72WHb1vW27tAQUAg0eu1ntejatpQCU7ViF6uhgTITxXSLdMGmKbzWg7tt2-aAaOk7zuu277rZD4fpBv71vez7vuqX7boBoHqnxsGIbi2j43ohJWxbbIEYBrgTr2xGUDR+IMZujbsZJlAyY2omQC+3HSfx8m7Upm9QfB1j2MHLibGwCwoGwRz4DNAxxtnUS6YkirkjSLJcgB+rerQDsKbtSGtJ0nM9OvU0UFZcaevw+Cant6oLJhoKhu-GMTWZD3Ai9-37X6y9WpQYaw9-R4wDmGOwKdONwlFaCPShVGZDjpDgvQ5PGUL8LKGhl3YcmSvFzARKtNiZnikrtKOKHWxHAcozcIAKQgJAZwNmxxaDY3mEGU2kmeC2cittSfczDtG7gCAjKgOpC8dmJnffOvUwAK2HtAvfWkBN+gV7ubRwPa+DuGk-ck1U43re5ivreH8Pp-RBflNe4qcjrp0OjIX+A1-4qEAVnWIVgtBRztF-a+29C6Z1jJBQEedPSLBgN-aAYZNSVyWqXUIoUq5QBrn-aKkwp7NxiK3NsqU2LpW7jYMwwBnCIA9rAYA2BtaEA-IbecjdypJRknJBSm4jCUIPlA2hRINAOScgoMkxdXbP1Dq-X89lHLmnUbZLBsRlH6Ocuo0h14Qrl3uJQ6hCiE5hUbgwkszMWH9iAA
