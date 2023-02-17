package android.test.testciceronedi

import android.content.Context
import android.os.Bundle
import android.test.testciceronedi.databinding.FragmentItemBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


private const val TAG = "FragmentItem"


class FragmentItem : Fragment(){



    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!


    @Inject
    lateinit var factory : StateViewModel.Factory

    @Inject
    internal lateinit var navigation: Navigation

    private val viewModel: StateViewModel by lazy {
        ViewModelProvider(this, factory)[StateViewModel::class.java]
    }




    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().appComponent.inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.liveDataCounter.observe(viewLifecycleOwner) {
            binding.counter.text = viewModel.liveDataCounter.value?.getValue().toString()
        }


        binding.uuid.text = viewModel.uuid.toString()
        binding.forwardButton.setOnClickListener {
            updateCounter()
            navigation.openScreen()
        }
        binding.backButton.setOnClickListener {
            updateCounter()
            navigation.backScreen()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateCounter() {
        viewModel.counter.setValue(viewModel.counter.getValue() + 1)
    }


    companion object {
        fun newInstance():  FragmentItem = FragmentItem()

    }


}

