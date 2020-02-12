// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.mixed_fragments_on_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class FriendDetails(
  val __typename: String = "Character",
  val fragments: Fragments,
  val asHuman: AsHuman?,
  val asDroid: AsDroid?
) : GraphqlFragment {
  override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller { writer ->
    writer.writeString(RESPONSE_FIELDS[0], this@FriendDetails.__typename)
    this@FriendDetails.fragments.marshaller().marshal(writer)
    writer.writeFragment(this@FriendDetails.asHuman?.marshaller())
    writer.writeFragment(this@FriendDetails.asDroid?.marshaller())
  }

  companion object {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forFragment("__typename", "__typename", listOf(
          ResponseField.Condition.typeCondition(arrayOf("Human"))
        )),
        ResponseField.forFragment("__typename", "__typename", listOf(
          ResponseField.Condition.typeCondition(arrayOf("Droid"))
        ))
        )

    val FRAGMENT_DEFINITION: String = """
        |fragment FriendDetails on Character {
        |  __typename
        |  ...CharacterDetails
        |  ... on Human {
        |    homePlanet
        |  }
        |  ... on Droid {
        |    primaryFunction
        |  }
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): FriendDetails = reader.run {
      val __typename = readString(RESPONSE_FIELDS[0])
      val fragments = Fragments(reader)
      val asHuman = readFragment<AsHuman>(RESPONSE_FIELDS[2]) { reader ->
        AsHuman(reader)
      }
      val asDroid = readFragment<AsDroid>(RESPONSE_FIELDS[3]) { reader ->
        AsDroid(reader)
      }
      FriendDetails(
        __typename = __typename,
        fragments = fragments,
        asHuman = asHuman,
        asDroid = asDroid
      )
    }
  }

  data class Fragments(
    val characterDetails: CharacterDetails
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller { writer ->
      writer.writeFragment(this@Fragments.characterDetails.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forFragment("__typename", "__typename", listOf(
            ResponseField.Condition.typeCondition(arrayOf("Human", "Droid"))
          ))
          )

      operator fun invoke(reader: ResponseReader): Fragments = reader.run {
        val characterDetails = readFragment<CharacterDetails>(RESPONSE_FIELDS[0]) { reader ->
          CharacterDetails(reader)
        }
        Fragments(
          characterDetails = characterDetails
        )
      }
    }
  }

  interface FriendDetailCharacter {
    fun marshaller(): ResponseFieldMarshaller
  }

  data class AsHuman(
    val __typename: String = "Human",
    /**
     * The home planet of the human, or null if unknown
     */
    val homePlanet: String?
  ) : FriendDetailCharacter {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@AsHuman.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@AsHuman.homePlanet)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("homePlanet", "homePlanet", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): AsHuman = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])
        val homePlanet = readString(RESPONSE_FIELDS[1])
        AsHuman(
          __typename = __typename,
          homePlanet = homePlanet
        )
      }
    }
  }

  data class AsDroid(
    val __typename: String = "Droid",
    /**
     * This droid's primary function
     */
    val primaryFunction: String?
  ) : FriendDetailCharacter {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@AsDroid.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@AsDroid.primaryFunction)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("primaryFunction", "primaryFunction", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): AsDroid = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])
        val primaryFunction = readString(RESPONSE_FIELDS[1])
        AsDroid(
          __typename = __typename,
          primaryFunction = primaryFunction
        )
      }
    }
  }
}
