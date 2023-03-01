# Camel K API Example

## Before you begin

Make sure you check-out this repository from git and open it with [VSCode](https://code.visualstudio.com/).


### Installing OpenShift Serverless

This demo also needs OpenShift Serverless (Knative) installed and working.

Go to the OpenShift 4.x WebConsole page, use the OperatorHub menu item on the left hand side then find and install **"OpenShift Serverless"** 
from a channel that best matches your OpenShift version.

The operator installation page reports links to the documentation where you can find information about **additional steps** that must
be done in order to have OpenShift serverless completely installed into your cluster.

Make sure you follow all the steps in the documentation before continuing to the next section.

## Preparing the cluster

This example can be run on any OpenShift 4.6+ cluster or a local development instance (such as [CRC](https://github.com/code-ready/crc)). Ensure that you have a cluster available and login to it using the OpenShift `oc` command line tool.


You need to install the Camel K operator in the `camel-api` project. To do so, go to the OpenShift 4.x web console, login with a cluster admin account and use the OperatorHub menu item on the left to find and install **"Red Hat Integration - Camel K"**. You will be given the option to install it globally on the cluster or on a specific namespace.
If using a specific namespace, make sure you select the `camel-api` project from the dropdown list.
This completes the installation of the Camel K operator (it may take a couple of minutes).

When the operator is installed, from the OpenShift Help menu ("?") at the top of the WebConsole, you can access the "Command Line Tools" page, where you can download the **"kamel"** CLI, that is required for running this example. The CLI must be installed in your system path.

Refer to the **"Red Hat Integration - Camel K"** documentation for a more detailed explanation of the installation steps for the operator and the CLI.

You can use the following section to check if your environment is configured properly.

## Requirements

**Camel and JBang**

[Camel](https://camel.apache.org/download/) and [JBang](https://camel.apache.org/manual/camel-jbang.html) are required to run this demo locally.

Camel version 3.20.2 and JBang version 0.102.0 were used to create the demo. 

**OpenShift CLI ("oc")**

The OpenShift CLI tool ("oc") will be used to interact with the OpenShift cluster.

You need to connect to an OpenShift cluster in order to deploy the demo but it's not required to run it locally. 

**Apache Camel K CLI ("kamel")**

Apart from the support provided by the VS Code extension, you also need the Apache Camel K CLI ("kamel") in order to 
access all Camel K features.

**Knative installed on the cluster**

The cluster also needs to have Knative installed and working. Refer to steps above for information on how to install it in your cluster.

**VSCode Karavan Extension**

Download the [Karavan](https://marketplace.visualstudio.com/items?itemName=camel-karavan.karavan) extension for vscode to render routes & package the demo.

**Quarkus**

Quarkus version **2.16.1.Final** is required to run this demo. You can follow the installation insturctions [here](https://quarkus.io/get-started/).

**Maven**

[Maven](https://maven.apache.org/download.cgi) is used to manage dependencies for the Quarkus project. This demo was built with version 3.9.0.

**Java**

Java Version 11 or 17 is required to run this demo.

## Running integration Locally

Open this repository in VSCode. Right click on the camelk-rest-demo-yaml.camel.yaml file and scroll down to "Karavan: Open".

Once the Karavan nav bar opens, you can press the play button above the integrations, to run the local integration.

## Deploying the integration in Openshift

To deploy this in Openshift, you need to use the **Karavan: Deploy** phase, which will deploy the app in to the current project that you've signed in to on your openshift cluster.
