/*
 * Copyright 2011 Vincent Behar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.rundeck.cli.command;

import org.rundeck.api.RundeckClient;
import org.rundeck.api.domain.RundeckSystemInfo;
import com.beust.jcommander.Parameters;

/**
 * Display the status of a running RunDeck instance
 * 
 * @author Vincent Behar
 */
@Parameters(commandDescription = "Display the status of a running RunDeck instance")
public class StatusCommand implements Command {

    public static final transient String NAME = "status";

    public static final transient String[] ALIASES = { "st" };

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getAliases() {
        return ALIASES;
    }

    @Override
    public void execute(RundeckClient rundeck) {
        RundeckSystemInfo status = rundeck.getSystemInfo();

        System.out.println("RunDeck Status - " + status.getDate());
        System.out.println("Version " + status.getVersion() + " (build " + status.getBuild() + ")");
        System.out.println("Uptime : " + status.getUptime());
    }

}
