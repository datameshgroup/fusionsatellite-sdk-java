package au.com.dmg.fusion.data;

public enum StoredValueTransactionType {
    Reserve,    // Reserve the account (e.g. get an activation code).
    Activate,   // Activate the account or the card.
    Load,       // Load the account or the card with money.
    Unload,     // Unload the account.
    Reverse,    // Reverse an activation or loading.
    Duplicate, // Duplicate the code or number provided by the loading or activation.
    Verify // Checks if the card is valid
}
