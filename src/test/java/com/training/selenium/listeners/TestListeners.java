package com.training.selenium.listeners;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

import java.util.stream.Collectors;


import org.junit.platform.engine.TestSource;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.engine.support.descriptor.ClassSource;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.engine.TestExecutionResult;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

 public class TestListeners implements TestExecutionListener {
     protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

        public Description toDescription(TestIdentifier i) {
            Description d = new Description(i.getDisplayName());
            TestSource ts = i.getSource().orElse(null);
            if (ts instanceof MethodSource m) {
                d.setClassName(m.getJavaClass());
                d.setMethodName(m.getMethodName());
            }
            else if (ts instanceof ClassSource c) {
                d.setClassName(c.getJavaClass());
            } else if (ts != null) {
                throw new IllegalArgumentException("Unrecognized source");
            }
            return d;
        }

        public String shorterStacktrace(Throwable ex) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ex.printStackTrace(new PrintStream(os));
            return os.toString(StandardCharsets.UTF_8).lines().limit(6).collect(Collectors.joining("\n")) + "\n\t...";
        }


        @Override
        public void executionStarted(TestIdentifier i) {
            Calendar now = Calendar.getInstance();

            Description d = toDescription(i);
            if (d.methodName != null) {
                log("Starting Test <" + d.displayName + " " + now.get(Calendar.HOUR_OF_DAY)
                        + ":"
                        + now.get(Calendar.MINUTE) + "\n");
            }
         }

        @Override
        public void executionFinished(TestIdentifier i, TestExecutionResult r) {
            Calendar now = Calendar.getInstance();

            Description d = toDescription(i);
            if (d.methodName != null) { // skip class names
                if (r.getThrowable().isPresent()) {
                    log(shorterStacktrace(r.getThrowable().get()));
                }
                log("Ending Test <" + d.displayName + " " + now.get(Calendar.HOUR_OF_DAY)
                        + ":"
                        + now.get(Calendar.MINUTE) + "\n");
            }

        }

        void log(String message) {
            logger.info("*** " + message);
           // System.out.println("*** " + message);
        }

}

