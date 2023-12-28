package com.github.dinbtechit.firebase.language.codeFormatting

import com.github.dinbtechit.firebase.language.FirestoreRulesLanguage
import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.lang.Language
import com.intellij.psi.codeStyle.*


class FirestoreRulesCodeStyleSettings(settings: CodeStyleSettings) :
    CustomCodeStyleSettings("FirestoreRulesCodeStyleSettings", settings) {
}

class FirestoreRulesCodeStyleSettingsProvider() : CodeStyleSettingsProvider() {
    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings? {
        return FirestoreRulesCodeStyleSettings(settings)
    }

    override fun getConfigurableDisplayName(): String {
        return FirestoreRulesLanguage.INSTANCE.displayName
    }

    override fun createConfigurable(
        settings: CodeStyleSettings,
        modelSettings: CodeStyleSettings
    ): CodeStyleConfigurable {
        return object : CodeStyleAbstractConfigurable(settings, modelSettings, this.configurableDisplayName) {
            override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel {
                return FirestoreRulesCodeStyleMainPanel(currentSettings, settings)
            }
        }
    }
}

class FirestoreRulesCodeStyleMainPanel(currentSettings: CodeStyleSettings?, settings: CodeStyleSettings?) :
    TabbedLanguageCodeStylePanel(FirestoreRulesLanguage.INSTANCE, currentSettings, settings!!) {
    override fun initTabs(settings: CodeStyleSettings?) {
        addIndentOptionsTab(settings);
        addSpacesTab(settings);
        addBlankLinesTab(settings);
        addWrappingAndBracesTab(settings);
    }
}


class FirestoreLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider() {
    override fun getLanguage(): Language = FirestoreRulesLanguage.INSTANCE


    override fun getCodeSample(p0: SettingsType): String {
        return """
         // Sample Code
          rules_version = '2';
          service cloud.firestore {
           function name() {
            let variableName;
           }
          }        
        """.trimIndent()
    }

    override fun customizeSettings(consumer: CodeStyleSettingsCustomizable, settingsType: SettingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS")
            consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS")
        } else if (settingsType == SettingsType.INDENT_SETTINGS) {
            consumer.showStandardOptions("USE_TAB_CHARACTER")
            consumer.showStandardOptions("TAB_SIZE")
            consumer.showStandardOptions("INDENT_SIZE")
            consumer.showStandardOptions("CONTINUATION_INDENT_SIZE")
        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
            consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE")
        }
    }
}