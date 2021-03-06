package com.example.pokebase.providers.api

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
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface RxPokeApiService {

    // region Resource Lists

    // region Berries

    @GET("berry/")
    fun getBerryList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("berry-firmness/")
    fun getBerryFirmnessList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("berry-flavor/")
    fun getBerryFlavorList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion Berries

    // region Contests

    @GET("contest-type/")
    fun getContestTypeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("contest-effect/")
    fun getContestEffectList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    @GET("super-contest-effect/")
    fun getSuperContestEffectList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    // endregion Contests

    // region Encounters

    @GET("encounter-method/")
    fun getEncounterMethodList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("encounter-condition/")
    fun getEncounterConditionList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("encounter-condition-value/")
    fun getEncounterConditionValueList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Evolution

    @GET("evolution-chain/")
    fun getEvolutionChainList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    @GET("evolution-trigger/")
    fun getEvolutionTriggerList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    //region Games

    @GET("generation/")
    fun getGenerationList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokedex/")
    fun getPokedexList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("version/")
    fun getVersionList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("version-group/")
    fun getVersionGroupList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Items

    @GET("item/")
    fun getItemList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("item-attribute/")
    fun getItemAttributeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("item-category/")
    fun getItemCategoryList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("item-fling-effect/")
    fun getItemFlingEffectList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("item-pocket/")
    fun getItemPocketList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    //region Moves

    @GET("move/")
    fun getMoveList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-ailment/")
    fun getMoveAilmentList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-battle-style/")
    fun getMoveBattleStyleList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-category/")
    fun getMoveCategoryList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-damage-class/")
    fun getMoveDamageClassList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-learn-method/")
    fun getMoveLearnMethodList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-target/")
    fun getMoveTargetList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Locations

    @GET("location/")
    fun getLocationList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("location-area/")
    fun getLocationAreaList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pal-park-area/")
    fun getPalParkAreaList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("region/")
    fun getRegionList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Machines

    @GET("machine/")
    fun getMachineList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    // endregion

    // region Pokemon

    @GET("ability/")
    fun getAbilityList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("characteristic/")
    fun getCharacteristicList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    @GET("egg-group/")
    fun getEggGroupList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("gender/")
    fun getGenderList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("growth-rate/")
    fun getGrowthRateList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("nature/")
    fun getNatureList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokeathlon-stat/")
    fun getPokeathlonStatList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon/")
    fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-color/")
    fun getPokemonColorList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-form/")
    fun getPokemonFormList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-habitat/")
    fun getPokemonHabitatList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-shape/")
    fun getPokemonShapeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-species/")
    fun getPokemonSpeciesList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("stat/")
    fun getStatList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("type/")
    fun getTypeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Utility

    @GET("language/")
    fun getLanguageList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Pokemon

    @GET("ability/{id}/")
    fun getAbility(@Path("id") id: Int): Observable<Ability>

    @GET("characteristic/{id}/")
    fun getCharacteristic(@Path("id") id: Int): Observable<Characteristic>

    @GET("egg-group/{id}/")
    fun getEggGroup(@Path("id") id: Int): Observable<EggGroup>

    @GET("gender/{id}/")
    fun getGender(@Path("id") id: Int): Observable<Gender>

    @GET("growth-rate/{id}/")
    fun getGrowthRate(@Path("id") id: Int): Observable<GrowthRate>

    @GET("nature/{id}/")
    fun getNature(@Path("id") id: Int): Observable<Nature>

    @GET("pokeathlon-stat/{id}/")
    fun getPokeathlonStat(@Path("id") id: Int): Observable<PokeathlonStat>

    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int): Observable<Pokemon>

    @GET("pokemon/{id}/encounters/")
    fun getPokemonEncounterList(@Path("id") id: Int): Observable<List<LocationAreaEncounter>>

    @GET("pokemon-color/{id}/")
    fun getPokemonColor(@Path("id") id: Int): Observable<PokemonColor>

    @GET("pokemon-form/{id}/")
    fun getPokemonForm(@Path("id") id: Int): Observable<PokemonForm>

    @GET("pokemon-habitat/{id}/")
    fun getPokemonHabitat(@Path("id") id: Int): Observable<PokemonHabitat>

    @GET("pokemon-shape/{id}/")
    fun getPokemonShape(@Path("id") id: Int): Observable<PokemonShape>

    @GET("pokemon-species/{id}/")
    fun getPokemonSpecies(@Path("id") id: Int): Observable<PokemonSpecies>

    @GET("stat/{id}/")
    fun getStat(@Path("id") id: Int): Observable<Stat>

    @GET("type/{id}/")
    fun getType(@Path("id") id: Int): Observable<Type>

    // endregion Pokemon

    // region Utility

    @GET("language/{id}/")
    fun getLanguage(@Path("id") id: Int): Observable<Language>

    // endregion Utility
}
