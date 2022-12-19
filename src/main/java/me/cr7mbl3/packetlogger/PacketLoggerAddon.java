package me.cr7mbl3.packetlogger;

import me.cr7mbl3.packetlogger.modules.PacketLogger;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;

public class PacketLoggerAddon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final GithubRepo GITHUB_REPO = new GithubRepo("Cr7mbl3", "meteor-packet-logger");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Packet Logger");

        Modules.get().add(new PacketLogger());
    }

    @Override
    public GithubRepo getRepo() {
        return GITHUB_REPO;
    }

    @Override
    public String getWebsite() {
        return "https://github.com/Cr7mbl3/meteor-packet-logger";
    }

    @Override
    public String getCommit() {
        String commit = FabricLoader
            .getInstance()
            .getModContainer("meteor-packet-logger")
            .get().getMetadata()
            .getCustomValue("github:sha")
            .getAsString();

        return commit.isEmpty() ? null : commit.trim();
    }

    @Override
    public String getPackage() {
        return "me.cr7mbl3.packetlogger";
    }
}
