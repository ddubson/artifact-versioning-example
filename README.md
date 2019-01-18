[![Build Status](https://travis-ci.org/ddubson/artifact-versioning-example.svg?branch=master)](https://travis-ci.org/ddubson/artifact-versioning-example)

# Artifact Versioning and Publishing Example

Structured Git versioning using Semantic Versioning
---

In a traditional semantic versioning scheme, there exists a standard pattern of versioning:

```
MAJOR.MINOR.PATCH
```

[gradle-semantic-release-plugin](https://github.com/tschulte/gradle-semantic-release-plugin) uses 
this strategy to apply to Git commits

Here are ways to apply a version update on each commit

If a commit starts with:

- `fix(..)` --> bumps PATCH
- `docs(..)` --> skips github release, but creates a SNAPSHOT of the next PATCH version

[Full list of conventions](https://github.com/conventional-changelog-archived-repos/conventional-changelog-angular/blob/master/convention.md)

## Publishing source releases to GitHub

You must export `GH_TOKEN` environment variable to your environment with a [GitHub token](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/)
as the value to be able to use the `release` task.

### TravisCI

Add the `GH_TOKEN` variable to your TravisCI pipeline.

On every push to the `master` branch, a release will take place. 

Refer to `.travis.yml` file on how to create a TravisCI pipeline configuration.

## Example Workflow using TravisCI

1. On `develop`, add commits as per development flow. Semantic Release will not release on `develop`
2. Each commit should follow the convention outlined [here]((https://github.com/conventional-changelog-archived-repos/conventional-changelog-angular/blob/master/convention.md))
3. When ready to create a release, switch to `master` and merge all commits from `develop` and push!
4. On `master`, TravisCI will build the branch and trigger `release` which will cut SNAPSHOT into a release version.
5. `release` will also create a release artifact in `Releases`
6. `release` will also create a tag with the released version.

Publishing Docker artifacts
---

Using Palantir's Docker Gradle plugin, we can execute `docker` and `dockerPush` tasks to create and publish
the application artifact in container form.

```bash
# Creates a docker image, reading the input from docker/Dockerfile file
./gradlew docker 

# Publishes docker image to Docker Hub
./gradlew dockerPush
```

With TravisCI, we can enable the Docker service in the pipeline, and add our secret credentials to the environment:

```
travis encrypt DOCKER_USERNAME=myusername
travis encrypt DOCKER_PASSWORD=secretsecret
```

And both values to the `env` field in the docker stage.