package com.example.pokebase.providers.api

import io.reactivex.rxjava3.core.Observable
import com.example.pokebase.models.Ability
import com.example.pokebase.models.ApiResourceList
import com.example.pokebase.models.Characteristic
import com.example.pokebase.models.EggGroup
import com.example.pokebase.models.Gender
import com.example.pokebase.models.GrowthRate
import com.example.pokebase.models.Language
import com.example.pokebase.models.LocationAreaEncounter
import com.example.pokebase.models.NamedApiResourceList
import com.example.pokebase.models.Nature
import com.example.pokebase.models.PokeathlonStat
import com.example.pokebase.models.Pokemon
import com.example.pokebase.models.PokemonColor
import com.example.pokebase.models.PokemonForm
import com.example.pokebase.models.PokemonHabitat
import com.example.pokebase.models.PokemonShape
import com.example.pokebase.models.PokemonSpecies
import com.example.pokebase.models.Stat
import com.example.pokebase.models.Type

interface RxPokeApi {

    fun getBerryList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getBerryFirmnessList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getBerryFlavorList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getContestTypeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getContestEffectList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getSuperContestEffectList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getEncounterMethodList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getEncounterConditionList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getEncounterConditionValueList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getEvolutionChainList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getEvolutionTriggerList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getGenerationList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokedexList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getVersionList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getVersionGroupList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemAttributeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemCategoryList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemFlingEffectList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemPocketList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveAilmentList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveBattleStyleList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveCategoryList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveDamageClassList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveLearnMethodList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveTargetList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getLocationList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getLocationAreaList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPalParkAreaList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getRegionList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMachineList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getAbilityList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getCharacteristicList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getEggGroupList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getGenderList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getGrowthRateList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getNatureList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokeathlonStatList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonColorList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonFormList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonHabitatList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonShapeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonSpeciesList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getStatList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getTypeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getLanguageList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getAbility(id: Int): Observable<Ability>

    fun getCharacteristic(id: Int): Observable<Characteristic>

    fun getEggGroup(id: Int): Observable<EggGroup>

    fun getGender(id: Int): Observable<Gender>

    fun getGrowthRate(id: Int): Observable<GrowthRate>

    fun getNature(id: Int): Observable<Nature>

    fun getPokeathlonStat(id: Int): Observable<PokeathlonStat>

    fun getPokemon(id: Int): Observable<Pokemon>

    fun getPokemonEncounterList(id: Int): Observable<List<LocationAreaEncounter>>

    fun getPokemonColor(id: Int): Observable<PokemonColor>

    fun getPokemonForm(id: Int): Observable<PokemonForm>

    fun getPokemonHabitat(id: Int): Observable<PokemonHabitat>

    fun getPokemonShape(id: Int): Observable<PokemonShape>

    fun getPokemonSpecies(id: Int): Observable<PokemonSpecies>

    fun getStat(id: Int): Observable<Stat>

    fun getType(id: Int): Observable<Type>

    fun getLanguage(id: Int): Observable<Language>
}
