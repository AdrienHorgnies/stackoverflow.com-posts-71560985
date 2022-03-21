# How to extend a Mojo and get other Mojos from the same plugin in the Plexus container?

See SO post : https://stackoverflow.com/questions/71560985/how-to-extend-a-mojo-and-get-other-mojos-from-the-same-plugin-in-the-plexus-cont

## How to reproduce

    mvn clean install
    mvn license:aggregate-add-third-party # works
    mvn clean
    mvn report:my-goal # fails