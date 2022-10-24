<%--
  INTELLIJ: WHEN REBUIILDING ARTIFACTS, USE 'jeginaldo-fp' (original file name)
            RATHER THAN 'jreginaldo-fp' (final name specified in pom)

            Payara / Glassfish configs should also be using the original 'jeginaldo-fp'.war files
            for it to run correctly

            IntelliJ (or my current settings) does not seem to automatically build the required artifacts for the
            web app to run correctly.

            STEPS:
            1. [Maven] Clean
            2. [Maven] Verify (Seems to re-add all the required files)
            3. [IDE] Build -> Build artifacts -> jeginaldo-fp: war exploded
            4. [IDE] Run -> Edit configs -> Payara / Glassfish -> Ensure jeginaldo-fp: war exploded is being built
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <h1>Hello World!</h1>
</body>
</html>