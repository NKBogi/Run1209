package hu.gde.marathon

data class SectionDTO(
    val id: Long,
    val index: Int, // szakasz sorszáma
    val name: String, // szakasz neve
    val distance: String, // távolság méterben
    val start: Long, // időbélyeg
    val end: Long, // időbélyeg
    val options: List<String>, // váltóponton található lehetőségek - https://tinyurl.com/TypeConverter
    val openHours: String, // váltópont nyitvatartása
    val runnerName: String // futó neve
)
