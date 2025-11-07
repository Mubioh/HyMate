package com.mubioh.hymate.features.gamequeue;

import com.mubioh.hymate.features.Feature;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameQueueFeature implements Feature {
    public static final Map<String, String> GAME_MODE_COMMANDS = new LinkedHashMap<>();

    static {
        GAME_MODE_COMMANDS.put("Skyblock", "sb");

        GAME_MODE_COMMANDS.put("The Pit", "pit");

        GAME_MODE_COMMANDS.put("Speed Builders", "build_battle_speed_builders");

        GAME_MODE_COMMANDS.put("Disasters", "prototype_disasters");

        GAME_MODE_COMMANDS.put("Bedwars Solo", "bedwars_eight_one");
        GAME_MODE_COMMANDS.put("Bedwars Doubles", "bedwars_eight_two");
        GAME_MODE_COMMANDS.put("Bedwars (3v3v3v3)", "bedwars_four_three");
        GAME_MODE_COMMANDS.put("Bedwars (4v4v4v4)", "bedwars_four_four");
        GAME_MODE_COMMANDS.put("Bedwars (4v4)", "bedwars_two_four");

        GAME_MODE_COMMANDS.put("Skywars Normal Solo", "solo_normal");
        GAME_MODE_COMMANDS.put("Skywars Normal Doubles", "teams_normal");
        GAME_MODE_COMMANDS.put("Skywars Insane", "solo_insane");
        GAME_MODE_COMMANDS.put("Skywars Mini", "mini_normal");
        GAME_MODE_COMMANDS.put("Skywars Mega", "mega_doubles");

        GAME_MODE_COMMANDS.put("Duels Classic", "duels_classic_duel");
        GAME_MODE_COMMANDS.put("Duels Sumo", "duels_sumo_duel");
        GAME_MODE_COMMANDS.put("Duels Parkour", "duels_parkour_eight");
        GAME_MODE_COMMANDS.put("Duels No Debuff", "duels_potion_duel");
        GAME_MODE_COMMANDS.put("Duels Blitz", "duels_blitz_duel");
        GAME_MODE_COMMANDS.put("Duels Combo", "duels_combo_duel");
        GAME_MODE_COMMANDS.put("Duels Bow", "duels_bow_duel");
        GAME_MODE_COMMANDS.put("Duels Boxing", "duels_blitz_duel");
        GAME_MODE_COMMANDS.put("Duels TNT", "duels_boxing_duel");
        GAME_MODE_COMMANDS.put("Duels Mega Walls Solo", "duels_mw_duel");
        GAME_MODE_COMMANDS.put("Duels Mega Walls Doubles", "duels_mw_doubles");
        GAME_MODE_COMMANDS.put("Duels Bridge (1v1)", "duels_bridge_duel");
        GAME_MODE_COMMANDS.put("Duels Bridge (2v2)", "duels_bridge_doubles");
        GAME_MODE_COMMANDS.put("Duels Bridge (3v3)", "duels_bridge_threes");
        GAME_MODE_COMMANDS.put("Duels Bridge (4v4)", "duels_bridge_four");
        GAME_MODE_COMMANDS.put("Duels Bridge (2v2v2v2)", "duels_bridge_2v2v2v2");
        GAME_MODE_COMMANDS.put("Duels Bridge (3v3v3v3)", "duels_bridge_3v3v3v3");
        GAME_MODE_COMMANDS.put("Duels CTF (3v3)", "duels_capture_threes");
        GAME_MODE_COMMANDS.put("Duels Skywars Solo", "duels_sw_duel");
        GAME_MODE_COMMANDS.put("Duels Skywars Doubles", "duels_sw_doubles");
        GAME_MODE_COMMANDS.put("Duels UHC (1v1)", "duels_uhc_duel");
        GAME_MODE_COMMANDS.put("Duels UHC (2v2)", "duels_uhc_doubles");
        GAME_MODE_COMMANDS.put("Duels UHC (4v4)", "duels_uhc_four");
        GAME_MODE_COMMANDS.put("Duels UHC FFA", "duels_uhc_meetup");
        GAME_MODE_COMMANDS.put("Duels OP Solo", "duels_op_duel");
        GAME_MODE_COMMANDS.put("Duels OP Doubles", "duels_op_doubles");

        GAME_MODE_COMMANDS.put("Dropper", "arcade_dropper");
        GAME_MODE_COMMANDS.put("Party Games", "arcade_party_games_1");
        GAME_MODE_COMMANDS.put("Pixel Party", "arcade_pixel_party");
        GAME_MODE_COMMANDS.put("Blocking Dead", "arcade_day_one");
        GAME_MODE_COMMANDS.put("Creeper Defence", "arcade_creeper_defense");
        GAME_MODE_COMMANDS.put("Dragon Wars", "arcade_dragon_wars");
        GAME_MODE_COMMANDS.put("Ender Spleef", "arcade_ender_spleef");
        GAME_MODE_COMMANDS.put("Farm Hunt", "arcade_farm_hunt");
        GAME_MODE_COMMANDS.put("Football", "arcade_soccer");
        GAME_MODE_COMMANDS.put("Galaxy Wars", "arcade_starwars");
        GAME_MODE_COMMANDS.put("Hole In The Wall", "arcade_hole_in_the_wall");
        GAME_MODE_COMMANDS.put("Throw Out", "arcade_throw_out");
        GAME_MODE_COMMANDS.put("Pixel Painters", "arcade_pixel_painters");
        GAME_MODE_COMMANDS.put("Hypixel Says", "arcade_simon_says");
        GAME_MODE_COMMANDS.put("Mini Walls", "arcade_mini_walls");
        GAME_MODE_COMMANDS.put("Hide And Seek (Party Pooper)", "arcade_hide_and_seek_party_pooper");
        GAME_MODE_COMMANDS.put("Hide And Seek (Prop Hunt)", "arcade_hide_and_seek_prop_hunt");
        GAME_MODE_COMMANDS.put("Zombies Dead End", "arcade_zombies_dead_end");
        GAME_MODE_COMMANDS.put("Zombies Bad Blood", "arcade_zombies_bad_blood");
        GAME_MODE_COMMANDS.put("Zombies Alien Arcadium", "arcade_zombies_alien_arcadium");
        GAME_MODE_COMMANDS.put("Zombies Prison", "arcade_zombies_prison");

        GAME_MODE_COMMANDS.put("Murder Mystery Classic", "murder_classic");
        GAME_MODE_COMMANDS.put("Murder Mystery Double Up", "murder_double_up");
        GAME_MODE_COMMANDS.put("Murder Mystery Assassins", "murder_assassins");
        GAME_MODE_COMMANDS.put("Murder Mystery Infection", "murder_infection");

        GAME_MODE_COMMANDS.put("Vampirez", "vampirez");

        GAME_MODE_COMMANDS.put("Turbo Kart Racers", "tkr");

        GAME_MODE_COMMANDS.put("Walls", "walls");

        GAME_MODE_COMMANDS.put("Paintball", "paintball");

        GAME_MODE_COMMANDS.put("Arena (1v1)", "arena_1v1");
        GAME_MODE_COMMANDS.put("Arena (2v2)", "arena_2v2");
        GAME_MODE_COMMANDS.put("Arena (4v4)", "arena_4v4");

        GAME_MODE_COMMANDS.put("Quake Solo", "quake_solo");
        GAME_MODE_COMMANDS.put("Quake Teams", "quake_teams");

        GAME_MODE_COMMANDS.put("TNT Run", "tnt_tntrun");
        GAME_MODE_COMMANDS.put("TNT Tag", "tnt_tntag");
        GAME_MODE_COMMANDS.put("TNT Wizards", "tnt_capture");
        GAME_MODE_COMMANDS.put("Pvp Run", "tnt_pvprun");
        GAME_MODE_COMMANDS.put("Bow Spleef", "tnt_bowspleef");

        GAME_MODE_COMMANDS.put("Mega Walls Faceoff", "mw_face_off");
        GAME_MODE_COMMANDS.put("Mega Walls Standard", "mw_standard");

        GAME_MODE_COMMANDS.put("Build Battle Solo", "build_battle_solo_normal");
        GAME_MODE_COMMANDS.put("Build Battle Teams", "build_battle_teams_normal");
        GAME_MODE_COMMANDS.put("Build Battle Solo Pro", "build_battle_solo_pro");
        GAME_MODE_COMMANDS.put("Guess The Build", "build_battle_guess_the_build");

        GAME_MODE_COMMANDS.put("UHC Speed Solo", "speed_solo_normal");
        GAME_MODE_COMMANDS.put("UHC Speed Teams", "speed_team_normal");
        GAME_MODE_COMMANDS.put("UHC UHC Solo", "uhc_solo");
        GAME_MODE_COMMANDS.put("UHC UHC Teams", "uhc_teams");

        GAME_MODE_COMMANDS.put("Blitz SG Solo", "blitz_solo_normal");
        GAME_MODE_COMMANDS.put("Blitz SG Teams", "blitz_teams_normal");

        GAME_MODE_COMMANDS.put("Cops And Crims Defusal", "mcgo_normal");
        GAME_MODE_COMMANDS.put("Cops And Crims Challenge", "mcgo_normal_party");
        GAME_MODE_COMMANDS.put("Cops And Crims Gun Game", "mcgo_gungame");
        GAME_MODE_COMMANDS.put("Cops And Crims Team Deathmatch", "mcgo_deathmatch");

        GAME_MODE_COMMANDS.put("Warlords CTF", "warlords_ctf_mini");
        GAME_MODE_COMMANDS.put("Warlords Domination", "warlords_domination");
        GAME_MODE_COMMANDS.put("Warlords Team Deathmatch", "warlords_team_deathmatch");

        GAME_MODE_COMMANDS.put("Smash Heroes Solo", "super_smash_solo_normal");
        GAME_MODE_COMMANDS.put("Smash Heroes Friends", "super_smash_friends_normal");
        GAME_MODE_COMMANDS.put("Smash Heroes Teams", "super_smash_teams_normal");
        GAME_MODE_COMMANDS.put("Smash Heroes (1v1)", "super_smash_1v1_normal");
        GAME_MODE_COMMANDS.put("Smash Heroes (2v2)", "super_smash_2v2_normal");

        GAME_MODE_COMMANDS.put("Wool Wars", "wool_wool_wars_two_four");
        GAME_MODE_COMMANDS.put("Sheep Wars", "wool_sheep_wars_two_six");
    }

    @Override
    public void initialize() {}
}
